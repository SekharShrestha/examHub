package com.examServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examServer.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUserName(String userName);

	public void deleteById(Long userId);

}
