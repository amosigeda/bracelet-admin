package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Feedback;

@Repository
public interface FeedbackMapper {

	List<Feedback> queryFeedbackListPage(Page page);

	Feedback selectById(Integer id);

	int deleteById(Integer id);

}
