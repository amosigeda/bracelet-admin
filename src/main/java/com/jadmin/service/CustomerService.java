package com.jadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Customer;
import com.jadmin.mapper.CustomerMapper;
import com.jadmin.util.PageData;

@Service
public class CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 用户列表分页
	 * @param page
	 * @return
	 */
	public List<Customer> getUserListPage(Page page){
		return customerMapper.queryUserListPage(page);
	}
	/**
	 * 查询列表
	 * @param pd
	 * @return
	 */
	public List<Customer> getUserList(PageData pd){
		return customerMapper.queryUserList(pd);
	}
	/**
	 * 根据主键ID查询
	 * @param userId
	 * @return
	 */
	public Customer getByUserId(Integer userId){
		return customerMapper.selectByUserId(userId);
	}
	/**
	 * 根据用户名查询
	 * @param username
	 * @return
	 */
	public Customer getByUserName(String username){
		return customerMapper.selectByUserName(username);
	}
	/**
	 * 验证用户名
	 * @param pd
	 * @return
	 */
	public Customer validateUserName(PageData pd){
		return customerMapper.validateUserName(pd);
	}
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	public int insert(Customer user){
		return customerMapper.insert(user);
	}
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int update(Customer user){
		return customerMapper.update(user);
	}
	/**
	 * 根据主键ID删除
	 * @param userId
	 * @return
	 */
	public int deleteByUserId(Integer userId){
		return customerMapper.deleteByUserId(userId);
	}
	
}
