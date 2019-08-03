package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;

public class WelcomeAdmin extends Composite {

	private static WelcomeAdminUiBinder uiBinder = GWT.create(WelcomeAdminUiBinder.class);

	interface WelcomeAdminUiBinder extends UiBinder<Widget, WelcomeAdmin> {
	}

	public WelcomeAdmin() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public WelcomeAdmin(String adminemail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.adminemail=adminemail;
		setup();
	}
	@UiField
	MaterialButton b1;
	
	@UiField
	MaterialButton b2;
	
	@UiField
	MaterialButton b3;
	String adminemail;
	void setup()
	{
		b1.setPixelSize(550, 50);
		b2.setPixelSize(550, 50);
		b3.setPixelSize(550, 50);
		
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				AllCustomersList cl=new AllCustomersList(adminemail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(cl);
				
			}
		} );
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AllHawkersList ahl=new AllHawkersList(adminemail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(ahl);
				
			}
		});
		b3.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AdminLogin al=new AdminLogin();
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(al);
			}
		});
	}

}
