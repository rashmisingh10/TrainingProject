package com.shared;

import java.io.Serializable;

public class Hawkers implements Serializable {
	int n;
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String[] getH() {
		return h;
	}
	public void setH(String[] h) {
		this.h = h;
	}
	String h[]=new String[n];

}
