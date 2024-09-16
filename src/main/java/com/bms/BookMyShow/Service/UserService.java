package com.bms.BookMyShow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.BookMyShow.Entity.UserEntity;
import com.bms.BookMyShow.Exception.ResourceNotFoundException;
import com.bms.BookMyShow.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	public String addUser(UserEntity user) {	
		userRepo.save(user);
		return "user added successfully.";
	}
	
	public UserEntity getUser(int id) throws ResourceNotFoundException{
		return userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User with the :"+ id + " is not found."));
	}
}
