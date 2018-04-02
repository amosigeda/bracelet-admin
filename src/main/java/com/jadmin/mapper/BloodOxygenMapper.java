package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.BloodOxygen;

@Repository
public interface BloodOxygenMapper {

	List<BloodOxygen> queryBloodOxygenListPage(Page page);

	BloodOxygen selectById(Integer id);

	int insert(BloodOxygen bloodOxygen);

	int update(BloodOxygen bloodOxygen);

	int deleteById(Integer id);

}
