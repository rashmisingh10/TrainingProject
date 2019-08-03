package com.shared;

import java.io.Serializable;

public class PaymentDetails implements Serializable {
	int monthlycost;
	int days;
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getMonthlycost() {
		return monthlycost;
	}
	public void setMonthlycost(int monthlycost) {
		this.monthlycost = monthlycost;
	}	
	

}
