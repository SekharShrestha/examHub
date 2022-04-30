package com.examServer.service.xam.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examServer.entity.xam.Category;
import com.examServer.repo.xam.CategoryRepo;
import com.examServer.service.xam.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.categoryRepo.findAll());
	}

	@Override
	public Category getCategory(Long cid) {
		// TODO Auto-generated method stub
		return this.categoryRepo.findById(cid).get(); //.get() -> return value if value is present, else throw exception
	}

	@Override
	public void deleteCategory(Long cid) {
		// TODO Auto-generated method stub
//		Category category = new Category();
//		category.setCid(cid);
		this.categoryRepo.deleteById(cid);
		
	}

}
