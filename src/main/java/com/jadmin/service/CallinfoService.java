package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Callinfo;
import com.jadmin.mapper.CallinfoMapper;

@Service
public class CallinfoService {

	@Autowired
	private CallinfoMapper callinfoMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Callinfo> getCallinfoListPage(Page page) {
		return callinfoMapper.queryCallinfoListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Callinfo getById(Integer id) {
		return callinfoMapper.selectById(id);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return callinfoMapper.deleteById(id);
	}

}
