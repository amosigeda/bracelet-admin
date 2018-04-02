package com.jadmin.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jadmin.entity.Page;
import com.jadmin.entity.biz.Smslog;

@Repository
public interface SmslogMapper {

	List<Smslog> querySmslogListPage(Page page);

	Smslog selectById(Integer id);

	int deleteById(Integer id);

}
