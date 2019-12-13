package com.pactera.bg.budsc.bank.yongfu.serviceI;

import java.util.List;

import com.pactera.bg.budsc.bank.yongfu.po.User;

public interface UserServiceI {
	int insert(User user);

	List<User> select(User user);

}
