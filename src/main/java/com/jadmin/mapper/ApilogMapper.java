package com.jadmin.mapper;

import java.util.Map;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Apilog;

@Repository
public interface ApilogMapper {

	List<Map<String, Object>> getCntByStatus();

	List<Apilog> queryApilogListPage(Page page);

	Apilog selectById(Integer id);

	int deleteById(Integer id);

}
