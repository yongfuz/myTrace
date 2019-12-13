package com.pactera.bg.budsc.bank.yongfu.servcie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.bg.budsc.bank.yongfu.mapper.UserDistrictCodesMapper;
import com.pactera.bg.budsc.bank.yongfu.po.UserDistrictCodes;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserDistrictCodesServiceI;

@Service("userDistrictCodesService")
public class UserDistrictCodesServiceImpl implements UserDistrictCodesServiceI {

	Logger logger = LoggerFactory.getLogger(UserDistrictCodesServiceImpl.class);

	@Autowired
	private UserDistrictCodesMapper userDistrictCodesMapper;

	@Override
	public int insert(UserDistrictCodes userDistrictCodes) {
		int insert = userDistrictCodesMapper.insert(userDistrictCodes);
		return insert;
	}

	@Override
	public int update(UserDistrictCodes userDistrictCodes) {
		int update = userDistrictCodesMapper.update(userDistrictCodes);
		return update;
	}

	@Override
	public UserDistrictCodes selectByUserName(String userName) {
		UserDistrictCodes selectByUserName = userDistrictCodesMapper.selectByUserName(userName);
		return selectByUserName;
	}

}
