package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Feedback;
import com.jadmin.mapper.FeedbackMapper;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackMapper feedbackMapper;

	/**
	 * 列表分页
	 * @param page
	 * @return
	 */
	public List<Feedback> getFeedbackListPage(Page page) {
		return feedbackMapper.queryFeedbackListPage(page);
	}

	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	public Feedback getById(Integer id) {
		return feedbackMapper.selectById(id);
	}

	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		return feedbackMapper.deleteById(id);
	}

}
