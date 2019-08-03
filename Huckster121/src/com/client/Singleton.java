package com.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Singleton {
	
	static Singleton s=null;
	SearchServices ss=null;
	HawkerList hl=null;
	WelcomeHawker wh=null;
	NewCustomers nc=null;
	AddPlan ap=null;
	CustomerList cl=null;
	String clientemail,ser,hawkeremail;
	private Singleton()
	{
		
	}
	static Singleton getInstance()
	{
		if(s==null)
		{
			s=new Singleton();
		}
		return s;
	}
	public void fun()
	{
		if(History.getToken().equals("h"))
		{
			RootPanel.get("xyz").clear();
			RootPanel.get("xyz").add(getWelcomeHawker());
		}
		if(History.getToken().equals("a1")) {
			RootPanel.get("xyz").clear();
			RootPanel.get("xyz").add(getSearchServices());
		}
		
		if(History.getToken().equals("a2"))
		{
			RootPanel.get("abc").clear();
			RootPanel.get("abc").add(getHawkerList());
		}
		if(History.getToken().equals("h2"))
		{   
			RootPanel.get("xyz").clear();
			RootPanel.get("xyz").add(getAddPlan());
		}
		if(History.getToken().equals("h3"))
		{   
			RootPanel.get("xyz").clear();
			RootPanel.get("xyz").add(getNewCustomers());
		}
		if(History.getToken().equals("h1"))
		{   
			RootPanel.get("xyz").clear();
			RootPanel.get("xyz").add(getCustomerList());
		}
	}
	CustomerList getCustomerList() {
		if(cl==null)
		{
			cl=new CustomerList(hawkeremail);
		}
		return cl;
	}
	NewCustomers getNewCustomers() {
		if(nc==null)
		{
			nc=new NewCustomers(hawkeremail);
		}
		return nc;
	}
	SearchServices getSearchServices()
	{
		if(ss==null)
		{
			ss=new SearchServices(clientemail);
		}
		return ss;
	}
	HawkerList getHawkerList()
	{
		
		if(hl==null)
		{
			hl=new HawkerList(ser,clientemail);
		}
		return hl;
	}
	WelcomeHawker getWelcomeHawker()
	{
		if(wh==null)
		{
			wh=new WelcomeHawker(hawkeremail);
		}
		return wh;
	}
	AddPlan getAddPlan()
	{
		if(ap==null)
		{
			ap=new AddPlan(hawkeremail);
		}
		return ap;
	}
	

}
