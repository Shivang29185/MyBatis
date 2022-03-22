package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.User;
import com.crud.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		 return userService.getAllUsers();
	}

	@PostMapping
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return ("Record inserted successfully");
	}

	@DeleteMapping("{id}")
	public String deleteUser(@PathVariable("id") int id ) {
		userService.deleteUser(id);
		return ("Record deleted successfully");
	}

	@PutMapping("{id}")
	public String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return ("Record updated successfully");
	}

	@GetMapping("{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}

}