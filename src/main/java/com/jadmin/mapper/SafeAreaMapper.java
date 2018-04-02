package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Fence;
import com.jadmin.entity.biz.SafeArea;
import com.jadmin.util.PageData;

@Repository
public interface SafeAreaMapper {

	List<SafeArea> queryUserListPage(Page page);

	List<SafeArea> queryUserList(PageData pd);

	SafeArea selectByUserId(Integer userId);

	SafeArea selectByUserName(String username);

	SafeArea validateUserName(PageData pd);

	int insert(SafeArea user);

	int update(SafeArea user);

	int deleteByUserId(Integer userId);

}
