package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Voltage;
import com.jadmin.mapper.VoltageMapper;

@Service
public class VoltageService {

	@Autowired
	private VoltageMapper voltageMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Voltage> getVoltageListPage(Page page) {
		return voltageMapper.queryVoltageListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Voltage getById(Integer id){
		return voltageMapper.selectById(id);
	}

	/**
	 * 插入
	 * @param voltage
	 * @return
	 */
	public int insert(Voltage voltage) {
		return voltageMapper.insert(voltage);
	}

	/**
	 * 更新
	 * @param voltage
	 * @return
	 */
	public int update(Voltage voltage) {
		return voltageMapper.update(voltage);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return voltageMapper.deleteById(id);
	}

}
