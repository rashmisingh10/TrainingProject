package com.shared;

import java.io.Serializable;

public class PlanRequest implements Serializable {
	public String getClientemail() {
		return clientemail;
	}
	public void setClientemail(String clientemail) {
		this.clientemail = clientemail;
	}
	public String getHawkeremail() {
		return hawkeremail;
	}
	public void setHawkeremail(String hawkeremail) {
		this.hawkeremail = hawkeremail;
	}
	String clientemail;
	String hawkeremail;
	String plan;
	String plancost;
	public String getPlancost() {
		return plancost;
	}
	public void setPlancost(String plancost) {
		this.plancost = plancost;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	

}
