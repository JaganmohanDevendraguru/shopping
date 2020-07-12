package com.fixthepro.shopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fixthepro.shopping_back.dto.Category;

public class CategoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Category category = (Category) target;
		//check whether logo is attached or not
		if(category.getFile() == null || category.getFile().getOriginalFilename().equals("")){
			//field being validated, errorcode, message
			errors.rejectValue("file", "", "Please select an image file to upload");
			return;
		}
		
		if(!(category.getFile().getContentType().equals("image/jpeg") ||
				category.getFile().getContentType().equals("image/png") ||
				category.getFile().getContentType().equals("image/gif")
		)){
			//field being validated, errorcode, message
			errors.rejectValue("file", "", "Please select only valid image file types");
			return;
		}
	}

}
