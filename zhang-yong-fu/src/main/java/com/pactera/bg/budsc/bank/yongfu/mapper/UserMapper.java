package com.pactera.bg.budsc.bank.yongfu.mapper;

import java.util.List;

import com.pactera.bg.budsc.bank.yongfu.po.User;

public interface UserMapper {
	int insert(User user);

	List<User> select(User user);

}