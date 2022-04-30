package com.examServer.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examServer.entity.User;
import com.examServer.entity.UserRole;
import com.examServer.repo.RoleRepo;
import com.examServer.repo.UserRepo;
import com.examServer.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepo.findByUserName(user.getUserName());
		
		if(local != null) {
			System.out.println("User already exists");
			throw new Exception("User already present");
		}
		else {
			for(UserRole ur : userRoles) {
				roleRepo.save(ur.getRole()); //saving all roles of user
			}
			user.getUserRoles().addAll(userRoles); //associating all roles of user with the user
			local = this.userRepo.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String userName) {
		return userRepo.findByUserName(userName);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
	}

}
