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
import com.jadmin.entity.biz.Pushlog;
import com.jadmin.service.PushlogService;
import com.jadmin.util.PageData;

/**
 * 推送日志
 */
@Controller
@RequestMapping(value = "/pushlog")
public class PushlogController extends BaseController {

	@Autowired
	private PushlogService pushlogService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("pushlog:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Pushlog> pushlogList = pushlogService.getPushlogListPage(page);
		model.put("pushlogList", pushlogList);
		model.put("pd", pd);
		return "biz/pushlog/list";
	}

	/**
	 * 删除操作
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("pushlog:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			pushlogService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
