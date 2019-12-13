package com.pactera.bg.budsc.bank.yongfu.servcie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.bg.budsc.bank.yongfu.mapper.RegisterMapper;
import com.pactera.bg.budsc.bank.yongfu.po.Register;
import com.pactera.bg.budsc.bank.yongfu.serviceI.RegisterServiceI;

@Service("registerService")
public class RegisterImpl implements RegisterServiceI {
	Logger logger = LoggerFactory.getLogger(RegisterImpl.class);
	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public int insert(Register Register) {
		int insert = registerMapper.insert(Register);
		return insert;
	}

	@Override
	public Register selectByUserName(String userName) {
		Register selectByUserName = registerMapper.selectByUserName(userName);
		return selectByUserName;
	}

}
