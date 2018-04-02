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
import com.jadmin.entity.biz.BloodSugar;
import com.jadmin.service.BloodSugarService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 电量
 */
@Controller
@RequestMapping(value = "/bloodSugar")
public class BloodSugarController extends BaseController {

	@Autowired
	private BloodSugarService bloodSugarService;
	/**
	 * 列表页
	 */
	@RequiresPermissions("bloodSugar:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<BloodSugar> bloodSugarList = bloodSugarService.getBloodSugarListPage(page);
		model.put("bloodSugarList", bloodSugarList);
		model.put("pd", pd);
		return "biz/bloodsugar/list";
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequiresPermissions("bloodSugar:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/bloodsugar/add";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("bloodSugar:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			BloodSugar bloodSugar = new BloodSugar();
			bloodSugar.setBloodSugar(pd.getInteger("bloodSugar"));
			bloodSugar.setUserId(pd.getInteger("userId"));
			bloodSugar.setUploadTime(Tools.getCurrentTimestamp());
			bloodSugarService.insert(bloodSugar);
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
	@RequiresPermissions("bloodSugar:update")
	@RequestMapping(value = "/doEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		BloodSugar bloodSugar = bloodSugarService.getById(id);
		model.put("bloodSugar", bloodSugar);
		return "biz/bloodsugar/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("bloodSugar:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			System.out.println("值是="+pd.getInteger("bloodSugar"));
			int id = pd.getInteger("id");
			BloodSugar bloodSugar =bloodSugarService.getById(id);
			bloodSugar.setBloodSugar(pd.getInteger("bloodSugar"));
			bloodSugarService.update(bloodSugar);
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
	@RequiresPermissions("bloodSugar:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			bloodSugarService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
