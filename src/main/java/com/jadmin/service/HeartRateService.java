package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.HeartRate;
import com.jadmin.mapper.HeartRateMapper;

@Service
public class HeartRateService {

	@Autowired
	private HeartRateMapper heartRateMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<HeartRate> getHeartRateListPage(Page page) {
		return heartRateMapper.queryHeartRateListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public HeartRate getById(Integer id){
		return heartRateMapper.selectById(id);
	}

	/**
	 * 插入
	 * @param heartRate
	 * @return
	 */
	public int insert(HeartRate heartRate) {
		return heartRateMapper.insert(heartRate);
	}

	/**
	 * 更新
	 * @param heartRate
	 * @return
	 */
	public int update(HeartRate heartRate) {
		return heartRateMapper.update(heartRate);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return heartRateMapper.deleteById(id);
	}

}
