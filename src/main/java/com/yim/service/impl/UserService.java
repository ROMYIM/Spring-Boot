package com.yim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yim.entity.User;
import com.yim.mapper.IUserMapper;
import com.yim.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return deleteUser(id);
	}

}
