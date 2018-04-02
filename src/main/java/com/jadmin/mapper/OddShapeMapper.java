package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.OddShape;
import com.jadmin.util.PageData;

@Repository
public interface OddShapeMapper {

	List<OddShape> queryUserListPage(Page page);

	List<OddShape> queryUserList(PageData pd);

	OddShape selectByUserId(Integer userId);

	OddShape selectByUserName(String username);

	OddShape validateUserName(PageData pd);

	int insert(OddShape user);

	int update(OddShape user);

	int deleteByUserId(Integer userId);

}
