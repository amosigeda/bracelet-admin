package com.jadmin.mapper;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jadmin.entity.system.Resource;
import com.jadmin.util.PageData;

@Repository
public interface ResourceMapper {
	
	List<Resource> selectAllParentResc();
	
	List<Resource> selectSubResc(Integer parentId);
	
	List<Resource> selectLeftMenu(PageData pd);
	
	Resource selectByRescId(Integer rescId);
	
	List<Resource> selectByRoleId(Integer roleId);
	
	int insert(Resource resource);

    int update(Resource resource);
    
    int deleteByRescId(Integer rescId);
    
    int batchDeleteResc(List<Resource> rescList);

    public Set<String> findPermissions(PageData pd);
}