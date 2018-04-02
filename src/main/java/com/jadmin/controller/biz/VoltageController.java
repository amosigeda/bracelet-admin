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
import com.jadmin.entity.biz.Voltage;
import com.jadmin.service.VoltageService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 电量
 */
@Controller
@RequestMapping(value = "/voltage")
public class VoltageController extends BaseController {

	@Autowired
	private VoltageService voltageService;
	/**
	 * 列表页
	 */
	@RequiresPermissions("voltage:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Voltage> voltageList = voltageService.getVoltageListPage(page);
		model.put("voltageList", voltageList);
		model.put("pd", pd);
		return "biz/voltage/list";
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequiresPermissions("voltage:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/voltage/add";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("voltage:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			Voltage voltage = new Voltage();
			voltage.setVoltage(pd.getInteger("voltage"));
			voltage.setUserId(pd.getInteger("userId"));
			voltage.setUploadTime(Tools.getCurrentTimestamp());
			voltageService.insert(voltage);
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
	@RequiresPermissions("voltage:update")
	@RequestMapping(value = "/doEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		Voltage voltage = voltageService.getById(id);
		model.put("voltage", voltage);
		return "biz/voltage/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("voltage:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			System.out.println("值是="+pd.getInteger("voltage"));
			int id = pd.getInteger("id");
			Voltage voltage =voltageService.getById(id);
			voltage.setVoltage(pd.getInteger("voltage"));
			voltageService.update(voltage);
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
	@RequiresPermissions("voltage:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			voltageService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
