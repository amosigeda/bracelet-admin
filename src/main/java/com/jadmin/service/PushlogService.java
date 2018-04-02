package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Pushlog;
import com.jadmin.mapper.PushlogMapper;

@Service
public class PushlogService {

	@Autowired
	private PushlogMapper pushlogMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Pushlog> getPushlogListPage(Page page) {
		return pushlogMapper.queryPushlogListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Pushlog getById(Integer id) {
		return pushlogMapper.selectById(id);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return pushlogMapper.deleteById(id);
	}

}
