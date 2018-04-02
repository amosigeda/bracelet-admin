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
import com.jadmin.entity.biz.Step;
import com.jadmin.service.StepService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 步数
 */
@Controller
@RequestMapping(value = "/step")
public class StepController extends BaseController {

	@Autowired
	private StepService stepService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("step:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Step> stepList = stepService.getStepListPage(page);
		model.put("stepList", stepList);
		model.put("pd", pd);
		return "biz/step/list";
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequiresPermissions("step:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/step/add";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("step:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			Step step = new Step();
			step.setUserId(pd.getInteger("userId"));
			step.setImei(pd.getString("imei"));
			step.setStepNumber(pd.getInteger("stepNumber"));
			step.setCreatetime(Tools.getCurrentTimestamp());
			stepService.insert(step);
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
	@RequiresPermissions("step:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		Step step = stepService.getById(id);
		model.put("step", step);
		return "biz/step/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("step:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			int id = pd.getInteger("id");
			Step step = stepService.getById(id);
			step.setStepNumber(pd.getInteger("stepNumber"));
			stepService.update(step);
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
	@RequiresPermissions("step:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			stepService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
