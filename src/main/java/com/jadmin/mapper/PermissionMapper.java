package com.jadmin.mapper;

import java.util.List;

import com.jadmin.entity.system.Permission;

public interface PermissionMapper {
	
	List<Permission> selectList();
	
    int deleteByPermId(Integer permId);

    int insert(Permission permission);

    Permission selectByPermId(Integer permId);

    int update(Permission permission);
}