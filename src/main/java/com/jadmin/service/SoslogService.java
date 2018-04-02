package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Soslog;
import com.jadmin.mapper.SoslogMapper;

@Service
public class SoslogService {

	@Autowired
	private SoslogMapper soslogMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Soslog> getSoslogListPage(Page page) {
		return soslogMapper.querySoslogListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Soslog getById(Integer id) {
		return soslogMapper.selectById(id);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return soslogMapper.deleteById(id);
	}

}
