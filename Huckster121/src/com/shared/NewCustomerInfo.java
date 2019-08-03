package com.shared;

import java.io.Serializable;

public class NewCustomerInfo implements Serializable{
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String name;
	public String email;
	public String phone;
	public String address;
	public String plan;
	public String plancost;
	public String getPlancost() {
		return plancost;
	}
	public void setPlancost(String plancost) {
		this.plancost = plancost;
	}
	
	

}
