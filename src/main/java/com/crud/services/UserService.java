package com.crud.services;

import java.util.List;

import com.crud.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public void saveUser(User user);

	public void deleteUser(int id);

	public void updateUser(User user);

	public User getUserById(int id);

}
