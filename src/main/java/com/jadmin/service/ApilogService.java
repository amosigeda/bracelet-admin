package com.jadmin.service;

import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Apilog;
import com.jadmin.mapper.ApilogMapper;

@Service
public class ApilogService {

	@Autowired
	private ApilogMapper apilogMapper;

	public List<Map<String, Object>> getCntByStatus() {
		return apilogMapper.getCntByStatus();
	}

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Apilog> getApilogListPage(Page page) {
		return apilogMapper.queryApilogListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Apilog getById(Integer id) {
		return apilogMapper.selectById(id);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return apilogMapper.deleteById(id);
	}

}
