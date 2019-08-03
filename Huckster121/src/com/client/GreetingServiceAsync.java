package com.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shared.Add;
import com.shared.Assignedhawkerdetails;
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
import com.shared.Cale;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

void plandetails(planDetails n, AsyncCallback<String> asyncCallback)throws IllegalArgumentException;
void Calci(int a, Add ad,AsyncCallback<Add> callback) throws IllegalArgumentException;
void SetCalci(String a,Add ad,AsyncCallback<Add> callback) throws IllegalArgumentException;
void loginDetails(logindetails ld,AsyncCallback<String> callback) throws IllegalArgumentException;
void registerDetails(RegisterDetails rd,AsyncCallback<String> callback) throws IllegalArgumentException;
void customerDetails(String hawkeremail,String clientemail,AsyncCallback<CustomerDetails> callback) throws IllegalArgumentException;
void cust(String hn,AsyncCallback<CommonList> callback) throws IllegalArgumentException;
void hawkerDetails(String hawkeremail,AsyncCallback<HawkerDetails>callback) throws IllegalArgumentException;
void request(PlanRequest pd,AsyncCallback<String>callback) throws IllegalArgumentException;
void pay(AsyncCallback<PaymentDetails>callback) throws IllegalArgumentException;
void assignedHawker(String hawkeremail,String clientemail,AsyncCallback<Assignedhawkerdetails>callback) throws IllegalArgumentException;
void newCustomers(String name,AsyncCallback<CommonList>callback) throws IllegalArgumentException;
void newCustomersInfo(String clientemail,String hawkeremail,AsyncCallback<NewCustomerInfo>callback) throws IllegalArgumentException;
void requestAccept(RequestAccept ra,AsyncCallback<String>callback) throws IllegalArgumentException;
void Haw(String name,AsyncCallback<CommonList>callback) throws IllegalArgumentException;
void hawkerloginDetails(logindetails l,AsyncCallback<String>callback) throws IllegalArgumentException;
void adminloginDetails(logindetails l,AsyncCallback<String>callback) throws IllegalArgumentException;
void AllHaw(String name,AsyncCallback<CommonList>callback) throws IllegalArgumentException;
void removeHawker(String hawkeremail,AsyncCallback<String>callback) throws IllegalArgumentException;
void Allcust(String hn,AsyncCallback<CommonList> callback) throws IllegalArgumentException;
void removeClient(String name,AsyncCallback<String>callback) throws IllegalArgumentException;
void registerDetailsHawkers(RegisterDetails rd,AsyncCallback<String> callback) throws IllegalArgumentException;
void Cal(Cale d, AsyncCallback<String> callback) throws IllegalArgumentException;
void getCustomerDetails(String x,AsyncCallback<gcd>callback) throws IllegalArgumentException;
void assignedHawkerList(String x,AsyncCallback<CommonList>callback)throws IllegalArgumentException;
void getRequestedHawkers(String clientemail,AsyncCallback<CommonList>callback)throws IllegalArgumentException;
void requestedHawkerDetails(String hawkeremail,String clientemail, AsyncCallback<Requestedhawkerdetails>callback)throws IllegalArgumentException;






}
