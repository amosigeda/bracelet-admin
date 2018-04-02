package com.jadmin.controller.biz;

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
import com.jadmin.entity.biz.Fence;
import com.jadmin.service.CustomerService;
import com.jadmin.service.FenceService;
import com.jadmin.service.OddShapeService;
import com.jadmin.util.PageData;
import com.jadmin.util.ReadExcelTest;
import com.jadmin.util.Tools;
import com.jadmin.util.webUtil.ResponseUtils;

/**
 * 用户
 */
@Controller
@RequestMapping(value = "/fence")
public class FenceController extends BaseController {

	@Autowired
	private FenceService customerService;
	@Autowired
	private CustomerService customerServicee;

	/**
	 * 用户列表页
	 */
	@RequiresPermissions("fence:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Fence> userList = customerService.getUserListPage(page);
		model.put("userList", userList);
		model.put("pd", pd);
		return "biz/fence/list";
	}

	/**
	 * 用户添加页面
	 * 
	 * @return
	 */
	@RequiresPermissions("fence:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/fence/add";
	}

	/**
	 * 用户添加保存
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("fence:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			String username = pd.getString("username");
			String lat = pd.getString("lat");
			String lng = pd.getString("lng");
			Integer radius = pd.getInteger("radius");

			Fence fence = new Fence();
			fence.setLat(lat);
			fence.setRadius(radius);
			fence.setLng(lng);
			fence.setStatus(0);
			fence.setCreatetime(Tools.getCurrentTimestamp());
			fence.setUpdatetime(Tools.getCurrentTimestamp());
			fence.setUser_id(customerServicee.getByUserName(username).getUserId());
			customerService.insert(fence);

			model.put("msg", "success");
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
	@RequiresPermissions("fence:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		Fence user = customerService.getByUserId(id);
		model.put("user", user);
		return "biz/fence/edit";
	}

	/**
	 * 用户编辑保存
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("fence:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			int id = pd.getInteger("id");
			Fence user = customerService.getByUserId(id);
			user.setRadius(pd.getInteger("radius"));
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
	@RequiresPermissions("fence:delete")
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

	@RequiresPermissions(value = { "fence:create", "fence:update" }, logical = Logical.OR)
	@RequestMapping(value = "/validateUser")
	public void validateUser(@RequestParam(value = "username", required = true) String username,
			HttpServletResponse response, ModelMap model) throws Exception {
		System.out.println("开始验证用户名=" + username);
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
