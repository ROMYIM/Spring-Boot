package com.yim.service;

import com.yim.entity.User;

public interface IUserService {
	
	User getUserById(String id);
	
	int addUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(String id);
}
