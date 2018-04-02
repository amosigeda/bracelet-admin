package com.jadmin.controller.biz;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jadmin.controller.base.BaseController;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Callinfo;
import com.jadmin.service.CallinfoService;
import com.jadmin.util.PageData;

/**
 * 播报日志
 */
@Controller
@RequestMapping(value = "/callinfo")
public class CallinfoController extends BaseController {

	@Autowired
	private CallinfoService callinfoService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("callinfo:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Callinfo> callinfoList = callinfoService.getCallinfoListPage(page);
		model.put("callinfoList", callinfoList);
		model.put("pd", pd);
		return "biz/callinfo/list";
	}

	/**
	 * 删除操作
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("callinfo:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			callinfoService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
