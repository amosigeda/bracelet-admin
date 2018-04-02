package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Fence;
import com.jadmin.util.PageData;

@Repository
public interface FenceMapper {

	List<Fence> queryUserListPage(Page page);

	List<Fence> queryUserList(PageData pd);

	Fence selectByUserId(Integer userId);

	Fence selectByUserName(String username);

	Fence validateUserName(PageData pd);

	int insert(Fence user);

	int update(Fence user);

	int deleteByUserId(Integer userId);

}
