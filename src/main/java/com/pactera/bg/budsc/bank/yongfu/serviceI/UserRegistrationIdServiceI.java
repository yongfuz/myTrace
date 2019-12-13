package com.pactera.bg.budsc.bank.yongfu.serviceI;

import com.pactera.bg.budsc.bank.yongfu.po.UserRegistrationId;

public interface UserRegistrationIdServiceI {

	int insert(UserRegistrationId userRegistrationId);

	int update(UserRegistrationId userRegistrationId);

	UserRegistrationId selectByPrimaryKey(String userName);
}
