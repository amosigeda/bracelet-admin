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
import com.jadmin.entity.biz.Smslog;
import com.jadmin.service.SmslogService;
import com.jadmin.util.PageData;

/**
 * 短信发送日志
 */
@Controller
@RequestMapping(value = "/smslog")
public class SmslogController extends BaseController {

	@Autowired
	private SmslogService smslogService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("smslog:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Smslog> smslogList = smslogService.getSmslogListPage(page);
		model.put("smslogList", smslogList);
		model.put("pd", pd);
		return "biz/smslog/list";
	}

	/**
	 * 删除操作
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("smslog:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			smslogService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
