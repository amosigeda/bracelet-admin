package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Location;
import com.jadmin.mapper.LocationMapper;

@Service
public class LocationService {

	@Autowired
	private LocationMapper locationMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Location> getLocationListPage(Page page) {
		return locationMapper.queryLocationListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Location getById(Integer id){
		return locationMapper.selectById(id);
	}

	/**
	 * 插入
	 * @param location
	 * @return
	 */
	public int insert(Location location) {
		return locationMapper.insert(location);
	}

	/**
	 * 更新
	 * @param location
	 * @return
	 */
	public int update(Location location) {
		return locationMapper.update(location);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return locationMapper.deleteById(id);
	}

}
