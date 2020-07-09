package com.fixthepro.shopping_back.dto;

import java.io.Serializable;

public class Supplier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 209133369161274465L;
	
	private Integer supplierId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String email;
	private String phone;
	private String website;
	private boolean isActive = true;
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Supplier(Integer supplierId, String companyName, String contactName, String contactTitle, String email,
			String phone, String website, boolean isActive) {
		super();
		this.supplierId = supplierId;
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.isActive = isActive;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTitle() {
		return contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", companyName=" + companyName + ", contactName=" + contactName
				+ ", contactTitle=" + contactTitle + ", email=" + email + ", phone=" + phone + ", website=" + website
				+ ", isActive=" + isActive + "]";
	}

}
