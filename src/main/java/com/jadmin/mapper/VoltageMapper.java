package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Voltage;

@Repository
public interface VoltageMapper {

	List<Voltage> queryVoltageListPage(Page page);

	Voltage selectById(Integer id);

	int insert(Voltage voltage);

	int update(Voltage voltage);

	int deleteById(Integer id);

}
