package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Customer;
import com.jadmin.entity.biz.Frequency;
import com.jadmin.util.PageData;

@Repository
public interface FrequencyMapper {

	List<Frequency> queryUserListPage(Page page);

	List<Frequency> queryUserList(PageData pd);

	Frequency selectByUserId(Integer userId);

	Frequency selectByUserName(String username);

	Frequency validateUserName(PageData pd);

	int insert(Frequency user);

	int update(Frequency user);

	int deleteByUserId(Integer userId);

	List<Frequency> queryXinListPage(Page page);

	Frequency getByXinUserId(Integer id);

	int updateXin(Frequency user);

}
