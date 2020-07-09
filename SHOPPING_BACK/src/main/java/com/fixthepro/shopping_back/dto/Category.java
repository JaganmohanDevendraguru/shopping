package com.fixthepro.shopping_back.dto;

import java.io.Serializable;
/**
 * @author Jagan
 * @since 07/08/2020
 * 
 */

public class Category implements Serializable {


	private static final long serialVersionUID = -3561503180837181765L;
	
	private Integer categoryId;
	private String categoryName;
	private String description;
	
	//we save the image in disk and keep the references here	
	private String picturePath;
	/*
	 * active or not based on 0 1 0 - False - It means still in use 1 - True - It
	 * means we dont use anymore
	 */
	
	private boolean discontinued = false;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(Integer categoryId, String categoryName, String description, String picturePath,
			boolean discontinued) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.picturePath = picturePath;
		this.discontinued = discontinued;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public boolean isDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
				+ ", picturePath=" + picturePath + ", discontinued=" + discontinued + "]";
	}
	
}
