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
import com.jadmin.entity.biz.HeartPressure;
import com.jadmin.service.HeartPressureService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 血压
 */
@Controller
@RequestMapping(value = "/heartPressure")
public class HeartPressureController extends BaseController {

	@Autowired
	private HeartPressureService heartPressureService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("heartPressure:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<HeartPressure> heartPressureList = heartPressureService.getHeartPressureListPage(page);
		model.put("heartPressureList", heartPressureList);
		model.put("pd", pd);
		return "biz/heartPressure/list";
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequiresPermissions("heartPressure:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/heartPressure/add";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("heartPressure:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			HeartPressure heartPressure = new HeartPressure();
			heartPressure.setMaxHeartPressure(pd.getInteger("maxHeartPressure"));
			heartPressure.setMinHeartPressure(pd.getInteger("minHeartPressure"));
			heartPressure.setUserId(pd.getInteger("userId"));
			heartPressure.setImei(pd.getString("imei"));
			heartPressure.setUploadTime(Tools.getCurrentTimestamp());
			heartPressureService.insert(heartPressure);
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
	@RequiresPermissions("heartPressure:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		HeartPressure heartPressure = heartPressureService.getById(id);
		model.put("heartPressure", heartPressure);
		return "biz/heartPressure/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("heartPressure:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			int id = pd.getInteger("id");
			HeartPressure heartPressure = heartPressureService.getById(id);
			heartPressure.setMaxHeartPressure(pd.getInteger("maxHeartPressure"));
			heartPressure.setMinHeartPressure(pd.getInteger("minHeartPressure"));
			heartPressureService.update(heartPressure);
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
	@RequiresPermissions("heartPressure:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			heartPressureService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
