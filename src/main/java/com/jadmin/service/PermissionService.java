package com.jadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadmin.entity.system.Permission;
import com.jadmin.mapper.PermissionMapper;

@Service
public class PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	public List<Permission> getPermList(){
		return permissionMapper.selectList();
	}
}
