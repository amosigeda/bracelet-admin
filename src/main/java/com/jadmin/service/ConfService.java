package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Conf;
import com.jadmin.mapper.ConfMapper;

@Service
public class ConfService {

	@Autowired
	private ConfMapper confMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Conf> getConfListPage(Page page) {
		return confMapper.queryConfListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Conf getById(Integer id){
		return confMapper.selectById(id);
	}

	/**
	 * 插入
	 * @param conf
	 * @return
	 */
	public int insert(Conf conf) {
		return confMapper.insert(conf);
	}

	/**
	 * 更新
	 * @param conf
	 * @return
	 */
	public int update(Conf conf) {
		return confMapper.update(conf);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return confMapper.deleteById(id);
	}

}
