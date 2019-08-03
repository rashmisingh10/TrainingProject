package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;

public class WelcomeHawker extends Composite {

	private static WelcomeHawkerUiBinder uiBinder = GWT.create(WelcomeHawkerUiBinder.class);

	interface WelcomeHawkerUiBinder extends UiBinder<Widget, WelcomeHawker> {
	}
	

	public WelcomeHawker() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public WelcomeHawker(String hawkeremail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=hawkeremail;
		setup();
	}
	String hawkeremail="";
	@UiField
	MaterialButton b1;
	
	@UiField
	MaterialButton b2;
	
	@UiField
	MaterialButton b3;
	
	@UiField
	MaterialButton b4;
	void setup()
	{
		b1.setText("Show Existing Customers");
		b1.setPixelSize(550, 50);
		b2.setText("Change Existing Plan");
		b2.setPixelSize(550, 50);
		b3.setText(" Show Customer's Request");
		b3.setPixelSize(550, 50);
		b4.setText("Log Out");
		b4.setPixelSize(550, 50);
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CustomerList cl=new CustomerList(hawkeremail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(cl);
			}
		} );
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AddPlan ap=new AddPlan(hawkeremail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(ap);
				
				
			}
		});
		b3.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				NewCustomers nc=new NewCustomers(hawkeremail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(nc);
				
			}
		});
		b4.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				HawkerLogin hl=new HawkerLogin();
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(hl);
				
			}
		});
	}
	
	
		
		
	}


