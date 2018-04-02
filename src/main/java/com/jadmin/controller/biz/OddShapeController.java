package com.jadmin.controller.biz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.jadmin.controller.base.BaseController;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Customer;
import com.jadmin.entity.biz.OddShape;
import com.jadmin.service.CustomerService;
import com.jadmin.service.OddShapeService;
import com.jadmin.util.PageData;
import com.jadmin.util.ReadExcelTest;
import com.jadmin.util.Tools;
import com.jadmin.util.webUtil.ResponseUtils;

/**
 * 用户
 */
@Controller
@RequestMapping(value = "/oddshape")
public class OddShapeController extends BaseController {

	@Autowired
	private OddShapeService customerService;
	@Autowired
	private CustomerService customerServicee;
	/**
	 * 用户列表页
	 */
	@RequiresPermissions("oddshape:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<OddShape> userList = customerService.getUserListPage(page);
		model.put("userList", userList);
		model.put("pd", pd);
		return "biz/oddshape/list";
	}

	/**
	 * 用户添加页面
	 * 
	 * @return
	 */
	@RequiresPermissions("oddshape:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/oddshape/add";
	}

	/**
	 * 用户添加保存
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("oddshape:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(@RequestParam(value = "excelPath", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model) throws Exception {
		try {

			String username = request.getParameter("username");
			String name = request.getParameter("name");
			// PageData pd = this.getPageData();

			StringBuffer backSb = new StringBuffer();

			String dir = request.getSession(true).getServletContext().getRealPath("/");
			String fileName = file.getOriginalFilename();
			/*
			 * System.out.println("dir=" + dir + "/" + fileName); File
			 * targetFile = new File(dir, fileName); if (!targetFile.exists()) {
			 * targetFile.mkdirs(); } // 保存 file.transferTo(targetFile);
			 */
			String path = dir + "/" + fileName;

			OutputStream os = new FileOutputStream(path);
			os.write(file.getBytes(), 0, (int) file.getSize());
			os.flush();
			os.close();
			ReadExcelTest read = new ReadExcelTest();
			ArrayList<String> list = read.readExcel(path);
			/*
			 * Integer maxPhoneManage = null; if (maxPhoneManage == null) {
			 * maxPhoneManage = 0; }
			 */
			// int countNum = 0;
			// Long miniNum = 0L;
			// Long maxNum = 0L;
			for (String str : list) {
				// countNum++;
				if (backSb.length() <= 0) {
					backSb.append(str);
				} else {
					backSb.append(",");
					backSb.append(str);
				}
				// if (countNum % 2 == 1) {
				/*
				 * Long s = Long.parseLong(str); if (miniNum > s) { miniNum = s;
				 * } if (maxNum < s) { maxNum = s; }
				 */

				// logger.info("第一个="+str+",第二个="+list.get(countNum));

				// }
			}
			String point = backSb.toString();
			String msg = "success";
			char[] chars = point.toCharArray();
			int tete = 1;
			for (char aChar : chars) {
				boolean aacb = Tools.isChinesePunctuation(aChar);
				if (aacb) {
					msg = "dataerror";
					tete = 2;
					break;
				}
			}
			if (tete == 1) {
				String[] locations = point.split(",");
				if (locations.length % 2 != 0) {
					msg = "incomplete";
					tete = 2;
				} else {
					tete = 1;

					msg = "success";
				}
			}

			if (tete == 1) {
				OddShape user = new OddShape();
				/*Customer userr = customerServicee.getByUserName(username);
				if(userr!=null){
					userr.getUserId();
				}*/
				user.setUser_id(customerServicee.getByUserName(username).getUserId());
				user.setName(name);

				user.setType(3);
				user.setCreatetime(Tools.getCurrentTimestamp());
				user.setPoint(point);

				int zegjia = customerService.insert(user);
				if (zegjia > 0) {
					msg = "success";
				}
			}
			model.put("msg", msg);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

	/**
	 * 用户编辑页面
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequiresPermissions("oddshape:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		OddShape user = customerService.getByUserId(id);
		model.put("user", user);
		return "biz/oddshape/edit";
	}

	/**
	 * 用户编辑保存
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("oddshape:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			int id = pd.getInteger("id");

			OddShape user = customerService.getByUserId(id);
			user.setName(pd.getString("name"));
			customerService.update(user);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

	/**
	 * 删除用户操作
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequiresPermissions("oddshape:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			customerService.deleteByUserId(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

	@RequiresPermissions(value = { "oddshape:create", "oddshape:update" }, logical = Logical.OR)
	@RequestMapping(value = "/validateUser")
	public void validateUser(@RequestParam(value = "username", required = true) String username, HttpServletResponse response, ModelMap model)
			throws Exception {
		System.out.println("开始验证用户名="+username);
		Customer user = customerServicee.getByUserName(username);
		Map<String, Object> result = new HashMap<String, Object>();
		if (user != null) {
			result.put("result", "success");
		} else {
			result.put("result", "failed");
		}
		ResponseUtils.renderJson(response, new Gson().toJson(result));
	}
}
