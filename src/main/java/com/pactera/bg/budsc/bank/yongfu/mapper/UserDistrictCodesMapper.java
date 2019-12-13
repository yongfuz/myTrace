package com.pactera.bg.budsc.bank.yongfu.mapper;

import com.pactera.bg.budsc.bank.yongfu.po.UserDistrictCodes;

public interface UserDistrictCodesMapper {

	UserDistrictCodes selectByUserName(String userName);

	int insert(UserDistrictCodes trace);

	int update(UserDistrictCodes trace);

}