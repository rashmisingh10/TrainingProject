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
import com.shared.gcd;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

public class AdminCustomerInfo extends Composite {

	private static AdminCustomerInfoUiBinder uiBinder = GWT.create(AdminCustomerInfoUiBinder.class);

	interface AdminCustomerInfoUiBinder extends UiBinder<Widget, AdminCustomerInfo> {
	}

	public AdminCustomerInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public AdminCustomerInfo(String clientemail,String adminemail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.clientemail=clientemail;
		this.adminemail=adminemail;
		setup();
	}
	String clientemail,adminemail;
	@UiField
	MaterialLabel lblName;
	@UiField
	MaterialLink lblEmail;
	@UiField
	MaterialLink lblNumber;
	@UiField
	MaterialLink lblAddress;
	@UiField
	MaterialLink rb1;
	@UiField
	MaterialLink rb2;
	@UiField
	MaterialLink rb3;
	@UiField
	MaterialButton rem;
	@UiField
	MaterialImage imgProfile;
	@UiField
	MaterialIcon btnCloseProfile;
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	void setup()
	{
		btnCloseProfile.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AllCustomersList acl=new AllCustomersList(adminemail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(acl);
				
				
			}
		});
		imgProfile.setPixelSize(200, 200);
		a1.getCustomerDetails(clientemail, new AsyncCallback<gcd>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
			

			@Override
			public void onSuccess(gcd result) {
				lblName.setText(result.getName());
				lblAddress.setText(result.getAddress());
				lblNumber.setText(result.getPhone());
				lblEmail.setText(result.getEmail());
				
			}
		});
		
		rem.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				a1.removeClient(clientemail, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						if(result.equals("success"))
						{
							Window.alert("Success");
						}
						AllCustomersList adl=new AllCustomersList(adminemail);
						RootPanel.get("xyz").clear();
						RootPanel.get("xyz").add(adl);
						
					}
				});
			}
			

			
		});

	}


}
