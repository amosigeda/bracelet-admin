package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.BloodOxygen;
import com.jadmin.mapper.BloodOxygenMapper;

@Service
public class BloodOxygenService {

	@Autowired
	private BloodOxygenMapper bloodOxygenMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<BloodOxygen> getBloodOxygenListPage(Page page) {
		return bloodOxygenMapper.queryBloodOxygenListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public BloodOxygen getById(Integer id){
		return bloodOxygenMapper.selectById(id);
	}

	/**
	 * 插入
	 * @param voltage
	 * @return
	 */
	public int insert(BloodOxygen voltage) {
		return bloodOxygenMapper.insert(voltage);
	}

	/**
	 * 更新
	 * @param voltage
	 * @return
	 */
	public int update(BloodOxygen voltage) {
		return bloodOxygenMapper.update(voltage);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return bloodOxygenMapper.deleteById(id);
	}

}
