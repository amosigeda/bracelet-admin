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
import com.jadmin.entity.biz.Feedback;
import com.jadmin.service.FeedbackService;
import com.jadmin.util.PageData;

/**
 * 反馈
 */
@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController extends BaseController {

	@Autowired
	private FeedbackService feedbackService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("feedback:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Feedback> feedbackList = feedbackService.getFeedbackListPage(page);
		model.put("feedbackList", feedbackList);
		model.put("pd", pd);
		return "biz/feedback/list";
	}

	/**
	 * 删除操作
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("feedback:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			feedbackService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
