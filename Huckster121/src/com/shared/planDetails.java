package com.shared;

import java.io.Serializable;

public class planDetails implements Serializable{
	String mpm,qm,mpn,mpc,qc,email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMpm() {
		return mpm;
	}

	public void setMpm(String mpm) {
		this.mpm = mpm;
	}

	public String getQm() {
		return qm;
	}

	public void setQm(String qm) {
		this.qm = qm;
	}

	public String getMpn() {
		return mpn;
	}

	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	public String getMpc() {
		return mpc;
	}

	public void setMpc(String mpc) {
		this.mpc = mpc;
	}

	public String getQc() {
		return qc;
	}

	public void setQc(String qc) {
		this.qc = qc;
	}

}
