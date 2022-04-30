package com.examServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examServer.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
