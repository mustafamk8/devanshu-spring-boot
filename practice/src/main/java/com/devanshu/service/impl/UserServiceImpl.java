package com.devanshu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devanshu.entity.User;
import com.devanshu.repo.UserRepo;
import com.devanshu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User save = userRepo.save(user);
		return save;
	}

	@Override
	public User getSingleUser(int id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElse(null);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> allUser = userRepo.findAll();
		return allUser;
	}

	@Override
	public User updateUser(User user) {
		User u = userRepo.findById(user.getId()).orElse(null);
		u.setName(user.getName());
		u.setContact(user.getContact());
		u.setPassword(user.getPassword());

		return userRepo.save(u);
	}

	@Override
	public User getUserByName(String name) {
		User userName = userRepo.findByName(name);
		return userName;
	}

}
