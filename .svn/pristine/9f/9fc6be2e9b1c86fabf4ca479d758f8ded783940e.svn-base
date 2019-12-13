package com.pactera.bg.budsc.bank.yongfu.servcie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.bg.budsc.bank.yongfu.mapper.UserRegistrationIdMapper;
import com.pactera.bg.budsc.bank.yongfu.po.UserRegistrationId;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserRegistrationIdServiceI;

@Service("userRegistrationIdService")
public class UserRegistrationIdServiceImpl implements UserRegistrationIdServiceI {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRegistrationIdMapper userRegistrationIdMapper;

	@Override
	public int insert(UserRegistrationId userRegistrationId) {
		int insert = userRegistrationIdMapper.insert(userRegistrationId);
		return insert;
	}

	@Override
	public int update(UserRegistrationId userRegistrationId) {
		int update = userRegistrationIdMapper.update(userRegistrationId);
		return update;
	}

	@Override
	public UserRegistrationId selectByPrimaryKey(String userName) {
		UserRegistrationId selectByUserName = userRegistrationIdMapper.selectByPrimaryKey(userName);
		return selectByUserName;
	}

}
