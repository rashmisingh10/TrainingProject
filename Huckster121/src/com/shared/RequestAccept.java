package com.shared;

import java.io.Serializable;

public class RequestAccept implements Serializable {

	String hawkeremail;
	public String getHawkeremail() {
		return hawkeremail;
	}
	public void setHawkeremail(String hawkeremail) {
		this.hawkeremail = hawkeremail;
	}
	public String getClientemail() {
		return clientemail;
	}
	public void setClientemail(String clientemail) {
		this.clientemail = clientemail;
	}
	String clientemail;
}
