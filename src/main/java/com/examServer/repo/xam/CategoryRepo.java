package com.examServer.repo.xam;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examServer.entity.xam.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
