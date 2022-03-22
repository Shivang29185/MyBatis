package com.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.mapper.UserMapper;
import com.crud.model.User;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

	@Override
	public void saveUser(User user) {
		userMapper.saveData(user);
	}

	@Override
	public void deleteUser(int id) {
		userMapper.deleteData(id);
	}

	@Override
	public void updateUser(User user) {
		User updateuser = userMapper.findSingleUser(user.getId());
		updateuser.setFirstName(user.getFirstName());
		updateuser.setLastName(user.getLastName());
		updateuser.setMobile(user.getMobile());

		userMapper.updateData(updateuser);
	}

	@Override
	public User getUserById(int id) {
		return userMapper.findSingleUser(id);
	}

}