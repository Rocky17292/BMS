package com.bms.BookMyShow.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.BookMyShow.Entity.UserEntity;
import com.bms.BookMyShow.Service.UserService;

@RestController
@RequestMapping("/bms/user")
public class UserController {
	
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
	public void test() {
		System.out.println("hiii i am here man.");
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserEntity user) {
		String response = userService.addUser(user);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<?> getUser(@RequestParam("id")int id){
		UserEntity user = null;
		try {
			user = userService.getUser(id);
			return ResponseEntity.ok(user);
		}catch(Exception e) {
			logger.error("Error on Server side:" + e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
		}
	}
}
