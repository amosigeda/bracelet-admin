package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.HeartPressure;

@Repository
public interface HeartPressureMapper {

	List<HeartPressure> queryHeartPressureListPage(Page page);

	HeartPressure selectById(Integer id);

	int insert(HeartPressure heartPressure);

	int update(HeartPressure heartPressure);

	int deleteById(Integer id);

}
