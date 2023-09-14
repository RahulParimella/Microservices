package com.example.user.service;

import java.util.List;

import com.example.user.model.UserModel;

public interface UserService {
	UserModel saveUser(UserModel user);
	List<UserModel> getAllUsers();
	UserModel getUser(int id);
	String updateUser(int id,UserModel user);
	String deleteUser(int id);
}
