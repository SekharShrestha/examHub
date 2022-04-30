package com.examServer.controller.xam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examServer.entity.xam.Category;
import com.examServer.service.xam.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add-category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		return ResponseEntity.ok(this.categoryService.addCategory(category));		
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<?> getCategory(@PathVariable("cid") Long cid) {
		return ResponseEntity.ok(this.categoryService.getCategory(cid));
	}
	
	@GetMapping
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	@PutMapping
	public ResponseEntity<Category> updateCategory(@RequestBody Category category){
		return ResponseEntity.ok(this.categoryService.updateCategory(category));
	}
	
	@DeleteMapping("/{cid}")
	public void deleteCategory(@PathVariable("cid") Long cid) {
		this.categoryService.deleteCategory(cid);
	}

}
