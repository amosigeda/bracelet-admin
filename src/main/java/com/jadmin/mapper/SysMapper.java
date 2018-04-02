package com.jadmin.mapper;

import org.springframework.stereotype.Repository;
import com.jadmin.entity.biz.Sys;

@Repository
public interface SysMapper {

	Sys findOne();

	Sys selectById(Integer id);

	int update(Sys sys);

}
