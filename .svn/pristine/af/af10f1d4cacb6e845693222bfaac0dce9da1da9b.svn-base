package com.pactera.bg.budsc.bank.yongfu.servcie;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.bg.budsc.bank.yongfu.mapper.UserFriendMapper;
import com.pactera.bg.budsc.bank.yongfu.po.UserFriend;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserFriendServiceI;

@Service("userFriendService")
public class UserFriendServiceImpl implements UserFriendServiceI {
	Logger logger = LoggerFactory.getLogger(UserFriendServiceImpl.class);
	@Autowired
	private UserFriendMapper userFriendMapper;

	@Override
	public int insert(UserFriend user) {
		int insert = userFriendMapper.insert(user);
		return insert;
	}

	@Override
	public List<UserFriend> select(UserFriend user) {
		List<UserFriend> select = userFriendMapper.select(user);
		return select;
	}

	@Override
	public List<UserFriend> selectByUserName(String userName) {
		List<UserFriend> list = userFriendMapper.selectByUserName(userName);
		return list;
	}
}
