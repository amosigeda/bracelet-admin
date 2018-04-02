package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Customer;
import com.jadmin.util.PageData;

@Repository
public interface CustomerMapper {

	List<Customer> queryUserListPage(Page page);

	List<Customer> queryUserList(PageData pd);

	Customer selectByUserId(Integer userId);

	Customer selectByUserName(String username);

	Customer validateUserName(PageData pd);

	int insert(Customer user);

	int update(Customer user);

	int deleteByUserId(Integer userId);

}
