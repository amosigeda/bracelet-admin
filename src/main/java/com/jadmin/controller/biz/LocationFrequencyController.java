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
import com.jadmin.entity.biz.Frequency;
import com.jadmin.service.CustomerService;
import com.jadmin.service.FrequencyService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;
import com.jadmin.util.webUtil.ResponseUtils;

/**
 * 定位频率控制
 */
@Controller
@RequestMapping(value = "/frequency")
public class LocationFrequencyController extends BaseController {

	@Autowired
	private FrequencyService customerService;

	/**
	 * 用户列表页
	 */
	@RequiresPermissions("frequency:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Frequency> frequencyList = customerService.getUserListPage(page);
		model.put("frequencyList", frequencyList);
		model.put("pd", pd);
		return "biz/frequency/list";
	}
	
	
	@RequiresPermissions("frequency:view")
	@RequestMapping(value = "/listXin")
	public String listXin(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Frequency> frequencyList = customerService.getXinListPage(page);
		model.put("frequencyList", frequencyList);
		model.put("pd", pd);
		return "biz/frequency/xinlist";
	}

	/**
	 * 用户添加页面
	 * @return
	 */
	@RequiresPermissions("frequency:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/frequency/add";
	}

	/**
	 * 用户添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("frequency:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			Frequency user = new Frequency();
			
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
	@RequiresPermissions("frequency:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		logger.info("获得的id为="+id);
		Frequency user = customerService.getByUserId(id);
		model.put("user", user);
		return "biz/frequency/edit";
	}
	@RequiresPermissions("frequency:update")
	@RequestMapping(value = "/toEditXin")
	public String toEditXin(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		logger.info("获得的id为="+id);
		Frequency user = customerService.getByXinUserId(id);
		model.put("user", user);
		return "biz/frequency/editXin";
	}

	/**
	 * 用户编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("frequency:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			logger.info("有没有走到这里======");
			PageData pd = this.getPageData();
			Integer id = pd.getInteger("id");
			Integer frequencyTime= pd.getInteger("frequency_time");
			Frequency user = customerService.getByUserId(id);
			user.setFrequency_time(frequencyTime);
			user.setId(Long.valueOf(id+""));
			customerService.update(user);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}
	
	
	@RequiresPermissions("frequency:update")
	@RequestMapping(value = "/doEditXin", method = RequestMethod.POST)
	public String doEditXin(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			logger.info("有没有走到这里======");
			PageData pd = this.getPageData();
			Integer id = pd.getInteger("id");
			Integer frequencyTime= pd.getInteger("frequency_time");
			Frequency user = customerService.getByXinUserId(id);
			user.setFrequency_time(frequencyTime);
			user.setId(Long.valueOf(id+""));
			customerService.updateXin(user);
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
/*	@RequiresPermissions("customer:delete")
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

	*//**
	 * 校验用户
	 * @param userId
	 * @param userName
	 * @param response
	 * @param model
	 * @throws Exception
	 *//*
	@RequiresPermissions(value = { "customer:create", "customer:update" }, logical = Logical.OR)
	@RequestMapping(value = "/validateUser")
	public void validateUser(@RequestParam(value = "userId", required = false) Integer userId,
			@RequestParam(value = "userName", required = true) String userName, HttpServletResponse response, ModelMap model)
			throws Exception {
		
		logger.info("验证=============");
		PageData pd = new PageData();
		pd.put("userName", userName);
		pd.put("userId", userId);
		Frequency user = customerService.validateUserName(pd);
		Map<String, Object> result = new HashMap<String, Object>();

		if (user != null) {
			result.put("result", "failed");
		} else {
			result.put("result", "success");
		}
		ResponseUtils.renderJson(response, new Gson().toJson(result));
	}*/
}
