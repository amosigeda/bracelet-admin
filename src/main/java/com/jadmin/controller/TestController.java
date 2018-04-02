package com.jadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jadmin.controller.base.BaseController;
import com.jadmin.entity.Page;
import com.jadmin.util.PageData;

@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController {

	@RequestMapping(value = "/editor")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		model.put("pd", pd);
		return "test/editor";
	}

}
