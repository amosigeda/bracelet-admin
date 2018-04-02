package com.jadmin.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadmin.entity.Page;
import com.jadmin.entity.system.User;
import com.jadmin.mapper.UserMapper;
import com.jadmin.util.PageData;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 用户列表分页
	 * @param page
	 * @return
	 */
	public List<User> getUserListPage(Page page){
		return userMapper.queryUserListPage(page);
	}
	/**
	 * 查询列表
	 * @param pd
	 * @return
	 */
	public List<User> getUserList(PageData pd){
		return userMapper.queryUserList(pd);
	}
	/**
	 * 根据主键ID查询
	 * @param userId
	 * @return
	 */
	public User getByUserId(Integer userId){
		return userMapper.selectByUserId(userId);
	}
	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName){
		return userMapper.selectByUserName(userName);
	}
	/**
	 * 验证用户名
	 * @param pd
	 * @return
	 */
	public User validateUserName(PageData pd){
		return userMapper.validateUserName(pd);
	}
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	public int insert(User user){
		return userMapper.insert(user);
	}
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int update(User user){
		return userMapper.update(user);
	}
	/**
	 * 根据主键ID删除
	 * @param userId
	 * @return
	 */
	public int deleteByUserId(Integer userId){
		return userMapper.deleteByUserId(userId);
	}
	/**
	 * 根据用户名查询角色role_key
	 * @param userName
	 * @return
	 */
	public Set<String> findRoles(String userName){
		return roleService.findRolesByUserName(userName);
	}
	/**
	 * 根据用户名查询权限
	 * @param userName
	 * @return
	 */
	public Set<String> findPermissions(String userName){
		return resourceService.findPermissionsByUserName(userName);
	}
	/**
	 * 关联用户和角色
	 * 一个用户对应多个角色
	 * @param userid
	 * @param roleids
	 * @return
	 */
	public int insertUserRoles(int userid,int[] roleids){
		return roleService.insertUserRole(userid, roleids);
	}
	/**
	 * 根据用户id删除用户角色
	 * @param userId
	 * @return
	 */
	public int deleteUserRoleByUserId(int userId){
		return roleService.deleteUserRoleByUserId(userId);
	}
}
