package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.HawkerDetails;
import com.shared.PlanRequest;
import gwt.material.design.client.ui.*;
import gwt.material.design.addins.client.*;
public class HawkerInfo extends Composite {

	private static HawkerInfoUiBinder uiBinder = GWT.create(HawkerInfoUiBinder.class);

	interface HawkerInfoUiBinder extends UiBinder<Widget, HawkerInfo> {
	}

	public HawkerInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public HawkerInfo(String hawkeremail,String clientemail,String ser) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=hawkeremail;
		this.clientemail=clientemail;
		this.ser=ser;
		setup();
	}
	String hawkeremail="",clientemail="",ser="";
	String plan="";
	@UiField
	MaterialLabel lblName;
	@UiField
	MaterialLink lblEmail;
	@UiField
	MaterialLink lblNumber;
	@UiField
	MaterialLink lblAddress;
	@UiField
	MaterialRadioButton rb1;
	@UiField
	MaterialRadioButton rb2;
	@UiField
	MaterialRadioButton rb3;
	@UiField
	MaterialButton req;
	@UiField
	MaterialImage imgProfile;
	@UiField
	MaterialIcon btnCloseProfile;
	String milkprice,newspaperprice,comboprice,plancost;
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	void setup()
	{
		btnCloseProfile.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("xyz").clear();
				RootPanel.get("abc").clear();
				SearchServices ss=new SearchServices(clientemail);
				HawkerList hl=new HawkerList(ser,clientemail);
				RootPanel.get("abc").add(hl);
				RootPanel.get("xyz").add(ss);
				
				
			}
		});
		imgProfile.setPixelSize(200, 200);
		a1.hawkerDetails(hawkeremail, new AsyncCallback<HawkerDetails>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
			

			@Override
			public void onSuccess(HawkerDetails result) {
				lblName.setText(result.getName());
				lblAddress.setText(result.getAddress());
				lblNumber.setText(result.getPhone());
				lblEmail.setText(result.getEmail());
				if(result.getMilkprice()!=null)
				{
					rb1.setVisible(true);
					rb1.setText("Milk "+result.getMilkprice());
					milkprice=result.getMilkprice();
				}
				if(result.getNewspaperprice()!=null)
				{  
					rb2.setVisible(true);
					rb2.setText("Newspaper "+result.getNewspaperprice());
					newspaperprice=result.getNewspaperprice();

				}
				if(result.getComboprice()!=null)
				{
					rb3.setVisible(true);
					rb3.setText("Combo "+result.getComboprice());
					comboprice=result.getComboprice();

				}
				
			}
		});
		
		req.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!rb1.isChecked()&&!rb2.isChecked()&&!rb3.isChecked())
				{
					  new MaterialToast().toast("Please select plan to request.", 1000);
					return;
				}
				if(rb1.isChecked())
				{
					plan="milk";
					plancost=milkprice;
				}
				else if(rb2.isChecked())
				{
					plan="newspaper";
					plancost=newspaperprice;
				}
				else if(rb3.isChecked())
				{
					plan="combo";
					plancost=comboprice;
				}
				PlanRequest pr= new PlanRequest();
				pr.setClientemail(clientemail);
				pr.setHawkeremail(hawkeremail);
				pr.setPlan(plan);
				pr.setPlancost(plancost);
				a1.request(pr, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						Calen cl=new Calen(hawkeremail,clientemail);
						RootPanel.get("xyz").clear();
						RootPanel.get("xyz").add(cl);
					}
				});
				

			}
		});
	
				
		
	}

}
