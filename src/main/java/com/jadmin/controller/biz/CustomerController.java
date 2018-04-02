package com.jadmin.controller.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.jadmin.controller.base.BaseController;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Customer;
import com.jadmin.service.CustomerService;
import com.jadmin.util.MD5;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;
import com.jadmin.util.webUtil.ResponseUtils;

/**
 * 用户
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController extends BaseController {

	@Autowired
	private CustomerService customerService;

	/**
	 * 用户列表页
	 */
	@RequiresPermissions("customer:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Customer> userList = customerService.getUserListPage(page);
		model.put("userList", userList);
		model.put("pd", pd);
		return "biz/customer/list";
	}

	/**
	 * 用户添加页面
	 * @return
	 */
	@RequiresPermissions("customer:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/customer/add";
	}

	/**
	 * 用户添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("customer:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			logger.info(pd);
			Customer user = new Customer();
			user.setUsername(pd.getString("username"));
			if (StringUtils.isNotBlank(pd.getString("password"))) {
				String genPassword = MD5.GetMD5Code(pd.getString("password"));
				user.setPassword(genPassword);
			}
			String avatar = pd.getString("avatar");
			int idx = avatar.indexOf(";base64,");
			if (idx != -1) {
				avatar = avatar.substring(idx + ";base64,".length());
			}
			user.setAvatar(avatar);
			user.setNickname(pd.getString("nickname"));
			user.setSex(Integer.parseInt(pd.getString("sex")));
			user.setWeight(pd.getString("weight"));
			user.setHeight(pd.getString("height"));
			user.setAddress(pd.getString("address"));
			user.setDv(pd.getString("dv"));
			user.setSd(pd.getString("sd"));
			user.setImei(pd.getString("imei"));
			user.setCreatetime(Tools.getCurrentTimestamp());
			if (!StringUtils.isEmpty(user.getImei())) {
				user.setBindingtime(Tools.getCurrentTimestamp());
			}
			customerService.insert(user);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

	/**
	 * 用户编辑页面
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequiresPermissions("customer:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "userId", required = true) Integer userId, ModelMap model) {
		Customer user = customerService.getByUserId(userId);
		model.put("user", user);
		return "biz/customer/edit";
	}

	/**
	 * 用户编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("customer:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			int userId = pd.getInteger("userId");
			Customer user = customerService.getByUserId(userId);
			user.setUsername(pd.getString("username"));
			if (StringUtils.isNotBlank(pd.getString("password"))) {
				String genPassword = MD5.GetMD5Code(pd.getString("password"));
				user.setPassword(genPassword);
			}
			/*String avatar = pd.getString("avatar");
			logger.info("头像="+avatar);
			int idx = avatar.indexOf(";base64,");
			logger.info("头像idx="+idx);
			if (idx != -1) {
				avatar = avatar.substring(idx + ";base64,".length());
			}*/
			//user.setAvatar(avatar);
			user.setNickname(pd.getString("nickname"));
			user.setSex(Integer.parseInt(pd.getString("sex")));
			user.setWeight(pd.getString("weight"));
			user.setHeight(pd.getString("height"));
			user.setAddress(pd.getString("address"));
			user.setDv(pd.getString("dv"));
			user.setSd(pd.getString("sd"));
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
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequiresPermissions("customer:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "userId", required = true) Integer userId, ModelMap model) {
		try {
			customerService.deleteByUserId(userId);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

	/**
	 * 校验用户
	 * @param userId
	 * @param username
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequiresPermissions(value = { "customer:create", "customer:update" }, logical = Logical.OR)
	@RequestMapping(value = "/validateUser")
	public void validateUser(@RequestParam(value = "userId", required = false) Integer userId,
			@RequestParam(value = "username", required = true) String username, HttpServletResponse response, ModelMap model)
			throws Exception {
		PageData pd = new PageData();
		pd.put("username", username);
		pd.put("userId", userId);
		Customer user = customerService.validateUserName(pd);
		Map<String, Object> result = new HashMap<String, Object>();

		if (user != null) {
			result.put("result", "failed");
		} else {
			result.put("result", "success");
		}
		ResponseUtils.renderJson(response, new Gson().toJson(result));
	}
}
