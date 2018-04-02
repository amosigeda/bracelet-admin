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
import com.jadmin.entity.biz.Conf;
import com.jadmin.service.ConfService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 配置
 */
@Controller
@RequestMapping(value = "/conf")
public class ConfController extends BaseController {

	@Autowired
	private ConfService confService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("conf:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Conf> confList = confService.getConfListPage(page);
		model.put("confList", confList);
		model.put("pd", pd);
		return "biz/conf/list";
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequiresPermissions("conf:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/conf/add";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("conf:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			Conf conf = new Conf();
			conf.setKey(pd.getString("key"));
			conf.setValue(pd.getString("value"));
			conf.setDescription(pd.getString("description"));
			conf.setCreatetime(Tools.getCurrentTimestamp());
			conf.setUpdatetime(Tools.getCurrentTimestamp());
			confService.insert(conf);
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
	@RequiresPermissions("conf:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		Conf conf = confService.getById(id);
		model.put("conf", conf);
		return "biz/conf/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("conf:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			int id = pd.getInteger("id");
			Conf conf = confService.getById(id);
			conf.setKey(pd.getString("key"));
			conf.setValue(pd.getString("value"));
			conf.setDescription(pd.getString("description"));
			conf.setUpdatetime(Tools.getCurrentTimestamp());
			confService.update(conf);
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
	@RequiresPermissions("conf:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			confService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
