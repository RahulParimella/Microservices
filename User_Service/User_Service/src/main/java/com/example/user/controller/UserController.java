package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.UserModel;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {
		 return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);	
	}
	
	@GetMapping("/user")
	//Type1
	public ResponseEntity<List<UserModel>> getUsers(){
		
		return ResponseEntity.ok(userService.getAllUsers());
	}
	@GetMapping("/user/{id}")
	//Type2
	public ResponseEntity<UserModel> getUserById(@PathVariable int id) {
		UserModel userIdRetrieved = userService.getUser(id);
		return new ResponseEntity<UserModel>(userIdRetrieved,HttpStatus.OK);
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<String> updateUsers(@PathVariable int id ,UserModel user) {
		return ResponseEntity.ok(userService.updateUser(id, user));
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserId(@PathVariable int id) {
		return ResponseEntity.ok( userService.deleteUser(id));
	}
}
