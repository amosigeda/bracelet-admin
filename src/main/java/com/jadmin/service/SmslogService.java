package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Smslog;
import com.jadmin.mapper.SmslogMapper;

@Service
public class SmslogService {

	@Autowired
	private SmslogMapper smslogMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Smslog> getSmslogListPage(Page page) {
		return smslogMapper.querySmslogListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Smslog getById(Integer id) {
		return smslogMapper.selectById(id);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return smslogMapper.deleteById(id);
	}

}
