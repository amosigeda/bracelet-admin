package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.HeartRate;

@Repository
public interface HeartRateMapper {

	List<HeartRate> queryHeartRateListPage(Page page);

	HeartRate selectById(Integer id);

	int insert(HeartRate heartRate);

	int update(HeartRate heartRate);

	int deleteById(Integer id);

}
