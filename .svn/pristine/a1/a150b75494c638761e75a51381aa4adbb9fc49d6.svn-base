package com.pactera.bg.budsc.bank.yongfu.servcie;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frw.way.commons.utils.CollectionUtil;
import com.pactera.bg.budsc.bank.yongfu.mapper.UserMapper;
import com.pactera.bg.budsc.bank.yongfu.po.User;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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

	@Override
	public User selectById(User userQuery) {
		List<User> list = userMapper.select(userQuery);
		if (CollectionUtil.isNotEmpty(list)) {
			return list.get(0);
		} else {
			return new User();
		}
	}

	@Override
	public int update(User user) {
		int update = userMapper.update(user);
		return update;
	}

	@Override
	public List<User> selectFirends(Map<String, String> map) {
		List<User> list = userMapper.selectFirends(map);
		return list;
	}

	@Override
	public int updateExit() {
		int update = userMapper.updateExit();
		return update;
	}

	@Override
	public int updateByUserName(String userName) {
		int updateByUserName = userMapper.updateByUserName(userName);
		return updateByUserName;
	}
}
