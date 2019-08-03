package com.shared;

import java.io.Serializable;

public class HawkerDetails implements Serializable{
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMilkprice() {
		return milkprice;
	}
	public void setMilkprice(String milkprice) {
		this.milkprice = milkprice;
	}
	public String getNewspaperprice() {
		return newspaperprice;
	}
	public void setNewspaperprice(String newspaperprice) {
		this.newspaperprice = newspaperprice;
	}
	public String getComboprice() {
		return comboprice;
	}
	public void setComboprice(String comboprice) {
		this.comboprice = comboprice;
	}
	public String address;
	public String phone;
	public String email;
	public String milkprice;
	public String newspaperprice;
	public String comboprice;

}
