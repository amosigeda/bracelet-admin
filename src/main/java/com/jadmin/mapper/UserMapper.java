package com.jadmin.mapper;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jadmin.entity.Page;
import com.jadmin.entity.system.User;
import com.jadmin.util.PageData;

@Repository
public interface UserMapper {

	List<User> queryUserListPage(Page page);
	
	List<User> queryUserList(PageData pd);
	
	User selectByUserId(Integer userId);
	
	User selectByUserName(String userName);
	
	User validateUserName(PageData pd);
	
	int insert(User user);

    int update(User user);
	
	int deleteByUserId(Integer userId);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
