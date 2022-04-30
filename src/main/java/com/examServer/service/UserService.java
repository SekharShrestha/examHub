package com.examServer.service;

import java.util.Set;

import com.examServer.entity.User;
import com.examServer.entity.UserRole;

public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	public User getUser(String userName);
	
	public void deleteUser(Long userId);

}
