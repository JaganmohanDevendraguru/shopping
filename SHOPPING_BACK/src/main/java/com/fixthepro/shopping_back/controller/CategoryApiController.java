package com.fixthepro.shopping_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fixthepro.shopping_back.dto.Category;
import com.fixthepro.shopping_back.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryApiController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.getListOfCategories();
	}
	
	@GetMapping("/{id}")
	public Category getSingleCategory(@PathVariable("id") String sId){
		//parsing string to integer
		return categoryService.getCategoryById(Integer.parseInt(sId));
	}
	
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable("id") String sId, Category c){
		return null;
	}
}
