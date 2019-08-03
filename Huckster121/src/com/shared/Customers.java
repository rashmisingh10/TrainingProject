package com.shared;

import java.io.Serializable;

public class Customers implements Serializable{
	int n;
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String[] getC() {
		return c;
	}
	public void setC(String[] c) {
		this.c = c;
	}
	String c[]=new String[n];

}
