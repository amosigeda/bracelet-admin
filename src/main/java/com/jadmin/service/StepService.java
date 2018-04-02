package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Step;
import com.jadmin.mapper.StepMapper;

@Service
public class StepService {

	@Autowired
	private StepMapper stepMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Step> getStepListPage(Page page) {
		return stepMapper.queryStepListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Step getById(Integer id){
		return stepMapper.selectById(id);
	}

	/**
	 * 插入
	 * @param step
	 * @return
	 */
	public int insert(Step step) {
		return stepMapper.insert(step);
	}

	/**
	 * 更新
	 * @param step
	 * @return
	 */
	public int update(Step step) {
		return stepMapper.update(step);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return stepMapper.deleteById(id);
	}

}
