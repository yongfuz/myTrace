package com.pactera.bg.budsc.bank.yongfu.mapper;

import java.util.List;
import java.util.Map;

import com.pactera.bg.budsc.bank.yongfu.po.Trace;
import com.pactera.bg.budsc.bank.yongfu.po.User;

public interface TraceMapper {
	int insert(Map<String, Object> map);

	List<User> select(User user);

}