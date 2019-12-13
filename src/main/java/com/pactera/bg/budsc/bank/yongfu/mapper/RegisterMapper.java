package com.pactera.bg.budsc.bank.yongfu.mapper;

import com.pactera.bg.budsc.bank.yongfu.po.Register;

public interface RegisterMapper {
	int insert(Register Register);

	Register selectByUserName(String userName);

}