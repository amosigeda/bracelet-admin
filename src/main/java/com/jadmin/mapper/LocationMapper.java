package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Location;

@Repository
public interface LocationMapper {

	List<Location> queryLocationListPage(Page page);

	Location selectById(Integer id);

	int insert(Location location);

	int update(Location location);

	int deleteById(Integer id);

}
