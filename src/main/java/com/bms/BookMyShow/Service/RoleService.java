package com.bms.BookMyShow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.BookMyShow.Entity.Role;
import com.bms.BookMyShow.Repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	public String addRole(Role role){
		roleRepo.save(role);
		return "role got added successfully.";
	}
}
