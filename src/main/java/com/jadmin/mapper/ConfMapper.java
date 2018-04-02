package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Conf;

@Repository
public interface ConfMapper {

	List<Conf> queryConfListPage(Page page);

	Conf selectById(Integer id);

	int insert(Conf conf);

	int update(Conf conf);

	int deleteById(Integer id);

}
