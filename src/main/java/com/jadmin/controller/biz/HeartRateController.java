package com.jadmin.controller.biz;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.jadmin.controller.base.BaseController;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.HeartRate;
import com.jadmin.service.HeartRateService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 脉搏
 */
@Controller
@RequestMapping(value = "/heartRate")
public class HeartRateController extends BaseController {

	@Autowired
	private HeartRateService heartRateService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("heartRate:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<HeartRate> heartRateList = heartRateService.getHeartRateListPage(page);
		model.put("heartRateList", heartRateList);
		model.put("pd", pd);
		return "biz/heartRate/list";
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequiresPermissions("heartRate:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/heartRate/add";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("heartRate:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			HeartRate heartRate = new HeartRate();
			heartRate.setHeartRate(pd.getInteger("heartRate"));
			heartRate.setUserId(pd.getInteger("userId"));
			heartRate.setImei(pd.getString("imei"));
			heartRate.setUploadTime(Tools.getCurrentTimestamp());
			heartRateService.insert(heartRate);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

	/**
	 * 编辑页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("heartRate:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		HeartRate heartRate = heartRateService.getById(id);
		model.put("heartRate", heartRate);
		return "biz/heartRate/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("heartRate:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			int id = pd.getInteger("id");
			HeartRate heartRate = heartRateService.getById(id);
			heartRate.setHeartRate(pd.getInteger("heartRate"));
			heartRateService.update(heartRate);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

	/**
	 * 删除操作
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("heartRate:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			heartRateService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
