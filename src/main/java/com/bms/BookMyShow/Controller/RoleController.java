package com.bms.BookMyShow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.BookMyShow.Entity.Role;
import com.bms.BookMyShow.Service.RoleService;

@RestController
@RequestMapping("/bms/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("/addRole")
	public ResponseEntity<String> addRole(@RequestBody Role role){
		String res = roleService.addRole(role);
		return ResponseEntity.ok(res);
	}
}
