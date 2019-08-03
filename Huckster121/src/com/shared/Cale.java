package com.shared;

import java.io.Serializable;
import java.util.Date;

public class Cale implements Serializable {
	int n;
	public Date d[]=new Date[n];
	String clientemail;
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

	String hawkeremail;

	public Date[] getD() {
		return d;
	}

	public void setD(Date[] d) {
		this.d = d;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	

}
