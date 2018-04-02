package com.jadmin.controller.biz;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jadmin.controller.base.BaseController;
import com.jadmin.entity.biz.Sys;
import com.jadmin.service.SysService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 系统配置
 */
@Controller
@RequestMapping(value = "/sys")
public class SysController extends BaseController {

	@Autowired
	private SysService sysService;

	/**
	 * 编辑页面
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(ModelMap model) {
		Sys sys = sysService.findOne();
		model.put("sys", sys);
		return "biz/sys/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("sys:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		model.put("url", "/sys/toEdit");
		try {
			PageData pd = this.getPageData();
			int id = pd.getInteger("id");
			Sys sys = sysService.getById(id);
			sys.setServiceContent(pd.getString("serviceContent"));
			sys.setUpdatetime(Tools.getCurrentTimestamp());
			sysService.update(sys);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "prompt";
	}

}
