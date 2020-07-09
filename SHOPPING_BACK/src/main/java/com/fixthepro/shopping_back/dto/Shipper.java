package com.fixthepro.shopping_back.dto;

public class Shipper {
	
	private Integer shipperId;
	private String companyName;
	private String email;
	private String phone;
	private boolean isActive = true;
	
	public Shipper() {
		super();
	}
	
	public Shipper(Integer shipperId, String companyName, String email, String phone, boolean isActive) {
		super();
		this.shipperId = shipperId;
		this.companyName = companyName;
		this.email = email;
		this.phone = phone;
		this.isActive = isActive;
	}
	
	public Integer getShipperId() {
		return shipperId;
	}
	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Shipper [shipperId=" + shipperId + ", companyName=" + companyName + ", email=" + email + ", phone="
				+ phone + ", isActive=" + isActive + "]";
	}
}
