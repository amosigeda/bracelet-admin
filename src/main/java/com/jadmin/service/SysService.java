package com.jadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.biz.Sys;
import com.jadmin.mapper.SysMapper;

@Service
public class SysService {

	@Autowired
	private SysMapper sysMapper;
	
	public Sys findOne(){
		return sysMapper.findOne();
	}

	public Sys getById(Integer id){
		return sysMapper.selectById(id);
	}
	
	public int update(Sys sys){
		return sysMapper.update(sys);
	}
	
}
