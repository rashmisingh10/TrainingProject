package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.Requestedhawkerdetails;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;

public class RequestedHawkerDetails extends Composite {

	private static RequestedHawkerDetailsUiBinder uiBinder = GWT.create(RequestedHawkerDetailsUiBinder.class);

	interface RequestedHawkerDetailsUiBinder extends UiBinder<Widget, RequestedHawkerDetails> {
	}

	public RequestedHawkerDetails() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public RequestedHawkerDetails(String hawkeremail,String clientemail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=hawkeremail;
		this.clientemail=clientemail;
		setup();
	}
	@UiField
	MaterialButton b1;
	@UiField
	MaterialLabel l1,l2,l3,l4,l5,l6;
	String hawkeremail,clientemail;
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	void setup()
	{
		l1.setFontSize("2em");
		l2.setFontSize("2em");
		l3.setFontSize("2em");
		l4.setFontSize("2em");
		l5.setFontSize("2em");
		l6.setFontSize("2em");
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RequestedHawkers rh=new RequestedHawkers(clientemail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(rh);
			}
		});
		a1.requestedHawkerDetails(hawkeremail, clientemail, new AsyncCallback<Requestedhawkerdetails>() {
			
			@Override
			public void onSuccess(Requestedhawkerdetails result) {
				l1.setText("Hawker Name: "+result.getName());
				l2.setText("Hawker Email: "+result.getEmail());
				l3.setText("Hawker Phone: "+result.getPhone());
				l4.setText("Hawker Address: "+result.getAddress());
				l5.setText("Service Chosen: "+result.getPlan());
				l6.setText("Monthly Plan Cost: "+result.getPlancost());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

}
