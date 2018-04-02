package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.BloodSugar;
import com.jadmin.mapper.BloodSugarMapper;

@Service
public class BloodSugarService {

	@Autowired
	private BloodSugarMapper bloodSugarMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<BloodSugar> getBloodSugarListPage(Page page) {
		return bloodSugarMapper.queryBloodSugarListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public BloodSugar getById(Integer id){
		return bloodSugarMapper.selectById(id);
	}

	/**
	 * 插入
	 * @param voltage
	 * @return
	 */
	public int insert(BloodSugar voltage) {
		return bloodSugarMapper.insert(voltage);
	}

	/**
	 * 更新
	 * @param voltage
	 * @return
	 */
	public int update(BloodSugar voltage) {
		return bloodSugarMapper.update(voltage);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return bloodSugarMapper.deleteById(id);
	}

}
