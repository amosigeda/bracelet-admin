package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Pushlog;

@Repository
public interface PushlogMapper {

	List<Pushlog> queryPushlogListPage(Page page);

	Pushlog selectById(Integer id);

	int deleteById(Integer id);

}
