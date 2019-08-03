package com.client;


import com.shared.Add;
import com.shared.Assignedhawkerdetails;
import com.shared.Cale;
import com.shared.CustomerDetails;
import com.shared.CommonList;
import com.shared.HawkerDetails;
import com.shared.NewCustomerInfo;
import com.shared.PaymentDetails;
import com.shared.PlanRequest;
import com.shared.RegisterDetails;
import com.shared.RequestAccept;
import com.shared.Requestedhawkerdetails;
import com.shared.gcd;
import com.shared.logindetails;
import com.shared.planDetails;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	  
		
		String plandetails(planDetails pd) throws IllegalArgumentException;
		Add Calci(int a, Add ad) throws IllegalArgumentException;
		Add SetCalci(String a,Add ad) throws IllegalArgumentException;
		String loginDetails(logindetails ld) throws IllegalArgumentException;
		String registerDetails(RegisterDetails rd) throws IllegalArgumentException;
		CustomerDetails customerDetails(String hawkeremail,String clientemail) throws IllegalArgumentException;
		CommonList cust(String hn) throws IllegalArgumentException;
		HawkerDetails hawkerDetails(String hawkeremail) throws IllegalArgumentException;
		String request(PlanRequest pd) throws IllegalArgumentException;
		PaymentDetails pay() throws IllegalArgumentException;
		Assignedhawkerdetails assignedHawker(String hawkeremail,String clientemail) throws IllegalArgumentException;
		CommonList newCustomers(String name) throws IllegalArgumentException;
		NewCustomerInfo newCustomersInfo(String clientemail,String hawkeremail) throws IllegalArgumentException;
		String requestAccept(RequestAccept ra) throws IllegalArgumentException;
		CommonList Haw(String name) throws IllegalArgumentException;
		String hawkerloginDetails(logindetails l) throws IllegalArgumentException;
		String adminloginDetails(logindetails l) throws IllegalArgumentException;
		CommonList AllHaw(String name) throws IllegalArgumentException;
		String removeHawker(String hawkeremail) throws IllegalArgumentException;
		String removeClient(String ser) throws IllegalArgumentException;
		CommonList Allcust(String hn) throws IllegalArgumentException;
		String registerDetailsHawkers(RegisterDetails rd) throws IllegalArgumentException;
		String Cal(Cale d) throws IllegalArgumentException;
		gcd getCustomerDetails(String x) throws IllegalArgumentException;
		CommonList assignedHawkerList(String x)throws IllegalArgumentException;
		CommonList getRequestedHawkers(String clientemail)throws IllegalArgumentException;
		Requestedhawkerdetails requestedHawkerDetails(String hawkeremail,String clientemail)throws IllegalArgumentException;

}
