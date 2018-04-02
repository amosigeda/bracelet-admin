package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Step;

@Repository
public interface StepMapper {

	List<Step> queryStepListPage(Page page);

	Step selectById(Integer id);

	int insert(Step step);

	int update(Step step);

	int deleteById(Integer id);

}
