package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.BloodSugar;
import com.jadmin.entity.biz.Voltage;

@Repository
public interface BloodSugarMapper {

	List<BloodSugar> queryBloodSugarListPage(Page page);

	BloodSugar selectById(Integer id);

	int insert(BloodSugar bloodSugar);

	int update(BloodSugar bloodSugar);

	int deleteById(Integer id);

}
