package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Soslog;

@Repository
public interface SoslogMapper {

	List<Soslog> querySoslogListPage(Page page);

	Soslog selectById(Integer id);

	int deleteById(Integer id);

}
