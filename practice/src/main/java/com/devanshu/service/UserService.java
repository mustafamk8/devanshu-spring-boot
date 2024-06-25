package com.devanshu.service;

import java.util.List;

import com.devanshu.entity.User;

public interface UserService {

	public User createUser(User user);
	
	public User getSingleUser(int id);
	
	public List<User> getAllUser();
	
	public User updateUser(User user);
	
	public User getUserByName(String name);
}
