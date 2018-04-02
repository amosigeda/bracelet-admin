package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Callinfo;

@Repository
public interface CallinfoMapper {

	List<Callinfo> queryCallinfoListPage(Page page);

	Callinfo selectById(Integer id);

	int deleteById(Integer id);

}
