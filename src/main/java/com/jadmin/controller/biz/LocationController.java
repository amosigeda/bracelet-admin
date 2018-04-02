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
import com.jadmin.entity.biz.Location;
import com.jadmin.service.LocationService;
import com.jadmin.util.PageData;
import com.jadmin.util.Tools;

/**
 * 位置
 */
@Controller
@RequestMapping(value = "/location")
public class LocationController extends BaseController {

	@Autowired
	private LocationService locationService;

	/**
	 * 列表页
	 */
	@RequiresPermissions("location:view")
	@RequestMapping(value = "/list")
	public String list(Page page, ModelMap model) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Location> locationList = locationService.getLocationListPage(page);
		model.put("locationList", locationList);
		model.put("pd", pd);
		return "biz/location/list";
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequiresPermissions("location:create")
	@RequestMapping(value = "/toAdd")
	public String toAdd(ModelMap model) {
		return "biz/location/add";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("location:create")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			Location location = new Location();
			location.setUserId(pd.getInteger("userId"));
			location.setImei(pd.getString("imei"));
			location.setLocationType(pd.getString("locationType"));
			location.setLat(pd.getString("lat"));
			location.setLng(pd.getString("lng"));
			location.setAccuracy(pd.getInteger("accuracy"));
			location.setStatus(pd.getInteger("status"));
			location.setUploadTime(Tools.getCurrentTimestamp());
			locationService.insert(location);
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
	@RequiresPermissions("location:update")
	@RequestMapping(value = "/toEdit")
	public String toEdit(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		Location location = locationService.getById(id);
		model.put("location", location);
		return "biz/location/edit";
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("location:update")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			PageData pd = this.getPageData();
			int id = pd.getInteger("id");
			Location location = locationService.getById(id);
			location.setLat(pd.getString("lat"));
			location.setLng(pd.getString("lng"));
			locationService.update(location);
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
	@RequiresPermissions("location:delete")
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer id, ModelMap model) {
		try {
			locationService.deleteById(id);
			model.put("msg", "success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			model.put("msg", "failed");
		}
		return "save_result";
	}

}
