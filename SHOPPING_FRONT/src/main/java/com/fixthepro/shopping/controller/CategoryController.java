package com.fixthepro.shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fixthepro.shopping.validator.CategoryValidator;
import com.fixthepro.shopping_back.dto.Category;
import com.fixthepro.shopping_back.service.CategoryService;

@Controller
@RequestMapping("/view/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping()
	public String viewListOfCategories(Model model) {
		model.addAttribute("categories", categoryService.getListOfActiveCategories());
		model.addAttribute("heading", "Categories");
		return "admin/categories";
	}

	@GetMapping("/create")
	public String viewCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("heading", "Create a Category");
		return "admin/categoryForm";
	}

	@PostMapping("/create")
	public String saveCategory(@Valid @ModelAttribute("category") Category c, BindingResult result,
			@RequestParam("file") MultipartFile file, Model model, RedirectAttributes redAtt) {
		
		//include our custom validation
		new CategoryValidator().validate(c, result);
		if (result.hasErrors()) {
			model.addAttribute("title", "Create a Category");
			return "admin/categoryForm";
		}
		boolean response = false;
		
			response = categoryService.insertCategory(c, file);
			
		if (response == true) {
			redAtt.addFlashAttribute("success", "Category has been inserted successfully!");
			return "redirect:/view/categories";
		} else {
			model.addAttribute("title", "Create a Category");
			model.addAttribute("error", "Unable to insert a Category!");
			return "admin/categoryForm";
		}
	}
}
