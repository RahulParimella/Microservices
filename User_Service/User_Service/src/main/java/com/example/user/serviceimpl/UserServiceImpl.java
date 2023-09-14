package com.example.user.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.user.exception.UserNotFoundException;
import com.example.user.model.UserModel;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserModel saveUser(UserModel user) {
		// TODO Auto-generated method stub
		if(user.getName().isEmpty() || user.getName().length() == 0) {
			throw new UserNotFoundException("input fileds are empty");
		}
		return userRepo.save(user);
	}

	@Override
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserModel> users=userRepo.findAll();
		if(users.isEmpty()) {
			throw new UserNotFoundException("hey list is empty");
		}
		return users;
	}

	@Override
	public UserModel getUser(int id) {
		// TODO Auto-generated method stub
		UserModel user=userRepo.findById(id).get();
		return user;
		
	}

	@Override
	public String updateUser(@PathVariable int id, UserModel user) {
		// TODO Auto-generated method stub
		Optional<UserModel> usr=userRepo.findById(id);
		if(usr.isPresent()) {
			UserModel updateUser=usr.get();
			updateUser.setName(user.getName());
			updateUser.setEmail(user.getEmail());
			updateUser.setAbout(user.getAbout());
			updateUser.setId(user.getId());
			 userRepo.save(updateUser);
			 return "updated successfully";
		}
		else {
			throw new UserNotFoundException("User id not found:"+id);
		}
	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		Optional<UserModel> usr=userRepo.findById(id);
		if(usr.isPresent()) {
			
			userRepo.save(usr.get());
			return "deleted successfully";
		}
		else {
			throw new UserNotFoundException("User id not found:"+id);
		}
	}

}
