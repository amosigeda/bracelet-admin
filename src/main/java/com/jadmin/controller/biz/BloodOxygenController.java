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
import com.jadmin.entity.biz.BloodOxygen;
import com.jadmin.service.BloodOxygenService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 电量
 */
@Controller
@RequestMapping(value = "/bloodOxygen")
public class BloodOxygenController extends BaseController {

	@Autowired
	private BloodOxygenService bloodOxygenService;
	/**
	 * 列表页
	 */
	@RequiresPermissions("bloodOxygen:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<BloodOxygen> bloodOxygenList = bloodOxygenService.getBloodOxygenListPage(page);
		model.put("bloodOxygenList", bloodOxygenList);
		model.put("pd", pd);
		return "biz/bloodOxygen/list";
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequiresPermissions("bloodOxygen:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/bloodOxygen/add";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("bloodOxygen:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			BloodOxygen bloodOxygen = new BloodOxygen();
			bloodOxygen.setBloodOxygen(pd.getInteger("bloodOxygen"));
			bloodOxygen.setPulseRate(pd.getInteger("pulseRate"));
			bloodOxygen.setUserId(pd.getInteger("userId"));
			bloodOxygen.setUploadTime(Tools.getCurrentTimestamp());
			bloodOxygenService.insert(bloodOxygen);
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
	@RequiresPermissions("bloodOxygen:update")
	@RequestMapping(value = "/doEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		BloodOxygen bloodOxygen = bloodOxygenService.getById(id);
		model.put("bloodOxygen", bloodOxygen);
		return "biz/bloodOxygen/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("bloodOxygen:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			System.out.println("值是="+pd.getInteger("bloodOxygen"));
			int id = pd.getInteger("id");
			BloodOxygen bloodOxygen =bloodOxygenService.getById(id);
			bloodOxygen.setBloodOxygen(pd.getInteger("bloodOxygen"));
			bloodOxygenService.update(bloodOxygen);
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
	@RequiresPermissions("bloodOxygen:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			bloodOxygenService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
