package com.jadmin.controller.biz;

import java.util.Map;
import java.text.DecimalFormat;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jadmin.controller.base.BaseController;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Apilog;
import com.jadmin.service.ApilogService;
import com.jadmin.util.PageData;

/**
 * 接口日志
 */
@Controller
@RequestMapping(value = "/apilog")
public class ApilogController extends BaseController {
	DecimalFormat    df   = new DecimalFormat("######0.00"); 
	@Autowired
	private ApilogService apilogService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("apilog:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Map<String, Object>> statusCnt = apilogService.getCntByStatus();
		long totalCnt = 0;
		long succCnt = 0;
		long errCnt = 0;
		double succRadio = 0;
		for (Map<String, Object> sc : statusCnt) {
			String rstatus = String.valueOf(sc.get("rstatus"));
			long count = Long.parseLong(String.valueOf(sc.get("cnt")));
			totalCnt += count;
			if ("0".equals(rstatus)){
				succCnt += count;
			} else if ("1".equals(rstatus)){
				errCnt += count;
			}
		}
		if (totalCnt > 0) {
			succRadio =succCnt*1.0 / totalCnt*100;
		}
		String successRate=df.format(succRadio)+"%";
		List<Apilog> apilogList = apilogService.getApilogListPage(page);
		model.put("apilogList", apilogList);
		model.put("totalCnt", totalCnt);
		model.put("succCnt", succCnt);
		model.put("errCnt", errCnt);
		model.put("succRadio", successRate);
		model.put("pd", pd);
		return "biz/apilog/list";
	}

	/**
	 * 删除操作
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("apilog:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			apilogService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}
	/*public static void main(String[] args) {
		DecimalFormat    df   = new DecimalFormat("######0.00");  

		double d1 = 3.23456  ;
		System.out.println(df.format(d1));
	}*/

}
