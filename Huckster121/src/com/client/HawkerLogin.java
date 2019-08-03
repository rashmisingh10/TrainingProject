package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.logindetails;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class HawkerLogin extends Composite {

	private static HawkerLoginUiBinder uiBinder = GWT.create(HawkerLoginUiBinder.class);

	interface HawkerLoginUiBinder extends UiBinder<Widget, HawkerLogin> {
	}

	public HawkerLogin() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	String hawkeremail="";
	@UiField
	MaterialTextBox t1;
	@UiField
	MaterialTextBox t2;
	@UiField
	MaterialButton b1;
	@UiField
	MaterialLink b2;
	@UiField
	MaterialButton b3;
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	void setup()
	{
		b1.setText("Submit");
		b3.setText("Back");
		b3.setSize("100%", "30%");
		b1.setSize("100%", "30%");
		
	
		b3.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				starting s=new starting();
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(s);
				
			}
		});
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				HawkerRegister hr=new HawkerRegister();
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(hr);
			}
		});
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(t1.getText().isEmpty()||t2.getText().isEmpty())
				{
					 new MaterialToast().toast("Required Fields Cannot Be Empty.", 1000);
					return;
				}
				logindetails l=new logindetails();
				l.setUsername(t1.getText());
				l.setPassword(t2.getText());
				a1.hawkerloginDetails(l, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						
						if(result.equals("success"))
						{
						hawkeremail=t1.getText();
						WelcomeHawker wh=new WelcomeHawker(hawkeremail);
						RootPanel.get("xyz").clear();
						RootPanel.get("xyz").add(wh);
						}
						else
						{
							new MaterialToast().toast(result, 1000);
						}
						
					}
				});
			}
		});
	}

}
