package com.shared;

import java.io.Serializable;

public class Assignedhawkerdetails implements Serializable {
	public String name;
	public String phone;
	public String service;
	public String monthlyplan;
	public String email;
	public String address;
	int n;
	public String leave[]=new String[n];
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String[] getLeave() {
		return leave;
	}
	public void setLeave(String[] leave) {
		this.leave = leave;
	}

	public String getMonthlyplan() {
		return monthlyplan;
	}
	public void setMonthlyplan(String monthlyplan) {
		this.monthlyplan = monthlyplan;
	}


}
