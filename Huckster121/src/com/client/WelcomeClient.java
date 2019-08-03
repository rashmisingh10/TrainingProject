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

public class WelcomeClient extends Composite {

	private static WelcomeClientUiBinder uiBinder = GWT.create(WelcomeClientUiBinder.class);

	interface WelcomeClientUiBinder extends UiBinder<Widget, WelcomeClient> {
	}

	public WelcomeClient(String clientemail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.clientemail=clientemail;
		setup();
	}
	public WelcomeClient() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	String clientemail;
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
		b1.setPixelSize(550, 50);
		b2.setPixelSize(550, 50);
		b3.setPixelSize(550, 50);
		b4.setPixelSize(550, 50);
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AssignedHawkerList ahl=new AssignedHawkerList(clientemail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(ahl);
			}
		});
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RequestedHawkers rh=new RequestedHawkers(clientemail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(rh);
				
			}
		});
		b3.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			 SearchServices ss=new SearchServices(clientemail);
			 RootPanel.get("xyz").clear();
			 RootPanel.get("xyz").add(ss);
			
			}
		});
		b4.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			ClientLogin cl=new ClientLogin();
			RootPanel.get("xyz").clear();
			RootPanel.get("xyz").add(cl);
			}
		});
		
		
		
		
	}

}
