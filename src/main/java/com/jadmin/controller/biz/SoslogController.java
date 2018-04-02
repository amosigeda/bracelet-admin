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
import com.jadmin.entity.biz.Soslog;
import com.jadmin.service.SoslogService;
import com.jadmin.util.PageData;

/**
 * SOS日志
 */
@Controller
@RequestMapping(value = "/soslog")
public class SoslogController extends BaseController {

	@Autowired
	private SoslogService soslogService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("soslog:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Soslog> soslogList = soslogService.getSoslogListPage(page);
		model.put("soslogList", soslogList);
		model.put("pd", pd);
		return "biz/soslog/list";
	}

	/**
	 * 删除操作
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("soslog:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			soslogService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
