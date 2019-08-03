package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.NewCustomerInfo;
import com.shared.RequestAccept;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRadioButton;

public class NewCustomerDetail extends Composite {

	private static NewCustomerDetailUiBinder uiBinder = GWT.create(NewCustomerDetailUiBinder.class);

	interface NewCustomerDetailUiBinder extends UiBinder<Widget, NewCustomerDetail> {
	}

	public NewCustomerDetail() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public NewCustomerDetail(String clientemail,String hawkeremail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=hawkeremail;
		this.clientemail=clientemail;
		setup();
	}
	String hawkeremail,clientemail;
	
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	@UiField
	MaterialLabel lblName;
	@UiField
	MaterialLink lblEmail;
	@UiField
	MaterialLink lblNumber;
	@UiField
	MaterialLink lblAddress;
	@UiField
	MaterialLink lblPlan;
	@UiField
	MaterialButton req;
	@UiField
	MaterialImage imgProfile;
	@UiField
	MaterialIcon btnCloseProfile;
	void setup()
	{
		btnCloseProfile.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("xyz").clear();
				RootPanel.get("abc").clear();
				NewCustomers nc=new NewCustomers(hawkeremail);
				HawkerList hl=new HawkerList();
				RootPanel.get("xyz").add(hl);
				RootPanel.get("xyz").add(nc);
				
				
			}
		});
		imgProfile.setPixelSize(200, 200);
		a1.newCustomersInfo(clientemail,hawkeremail, new AsyncCallback<NewCustomerInfo>() {
			
			@Override
			public void onSuccess(NewCustomerInfo result) {
				lblName.setText(result.getName());
				lblAddress.setText(result.getAddress());
				lblNumber.setText(result.getPhone());
				lblEmail.setText(result.getEmail());
				lblPlan.setText(result.getPlan()+" "+result.getPlancost());
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.toString());
			}
		});
		req.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RequestAccept ra=new RequestAccept();
				ra.setClientemail(clientemail);
				ra.setHawkeremail(hawkeremail);
				a1.requestAccept(ra, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.toString());
						
					}

					@Override
					public void onSuccess(String result) {
						Window.alert(result);
						WelcomeHawker w=new WelcomeHawker(hawkeremail);
						RootPanel.get("xyz").clear();
						RootPanel.get("xyz").add(w);
						
					}
				});
				
			}
		});
		
		
		
	}

}
