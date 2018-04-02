package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.HeartPressure;
import com.jadmin.mapper.HeartPressureMapper;

@Service
public class HeartPressureService {

	@Autowired
	private HeartPressureMapper heartPressureMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<HeartPressure> getHeartPressureListPage(Page page) {
		return heartPressureMapper.queryHeartPressureListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public HeartPressure getById(Integer id){
		return heartPressureMapper.selectById(id);
	}

	/**
	 * 插入
	 * @param heartPressure
	 * @return
	 */
	public int insert(HeartPressure heartPressure) {
		return heartPressureMapper.insert(heartPressure);
	}

	/**
	 * 更新
	 * @param heartPressure
	 * @return
	 */
	public int update(HeartPressure heartPressure) {
		return heartPressureMapper.update(heartPressure);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return heartPressureMapper.deleteById(id);
	}

}
