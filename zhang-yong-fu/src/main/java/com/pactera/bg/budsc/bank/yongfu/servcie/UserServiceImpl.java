package com.pactera.bg.budsc.bank.yongfu.servcie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.bg.budsc.bank.yongfu.mapper.UserMapper;
import com.pactera.bg.budsc.bank.yongfu.po.User;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int insert(User user) {
		int insert = userMapper.insert(user);
		return insert;
	}

	@Override
	public List<User> select(User user) {
		List<User> select = userMapper.select(user);
		return select;
	}

}
