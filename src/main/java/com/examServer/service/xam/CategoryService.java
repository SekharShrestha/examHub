package com.examServer.service.xam;

import java.util.Set;

import com.examServer.entity.xam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long cid);
	public void deleteCategory(Long cid);

}
