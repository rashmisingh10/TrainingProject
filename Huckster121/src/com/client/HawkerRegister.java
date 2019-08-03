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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.RegisterDetails;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class HawkerRegister extends Composite {

	private static HawkerRegisterUiBinder uiBinder = GWT.create(HawkerRegisterUiBinder.class);

	interface HawkerRegisterUiBinder extends UiBinder<Widget, HawkerRegister> {
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);

	public HawkerRegister() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	String hawkeremail="";
	@UiField
	MaterialTextBox t1;
	@UiField
	MaterialTextBox t2;
	@UiField
	MaterialTextBox t3;
	@UiField
	MaterialTextBox t4;
	@UiField
	MaterialTextBox t5;
	@UiField
	MaterialTextBox t6;
	@UiField
	MaterialButton b1;
	@UiField
	MaterialButton b2;
	void setup()
	{
		b1.setSize("100%", "30%");
		b2.setSize("100%", "30%");
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				HawkerLogin cl=new HawkerLogin();
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(cl);
				
			}
		});
		b1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hawkeremail=t2.getText();
				if(t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty()||t6.getText().isEmpty())
				{
					new MaterialToast().toast("Required Fields Cannot Be Empty.", 1000);
					return;
				}
				if(!t5.getText().equals(t6.getText()))
				{
					new MaterialToast().toast("Password does not match", 1000);
					return;
				}
				RegisterDetails rd=new RegisterDetails();
				rd.setName(t1.getText());
				rd.setEmail(t2.getText());
				rd.setAddress(t3.getText());
				rd.setPhone(t4.getText());
				rd.setPassword(t5.getText());
				a1.registerDetailsHawkers(rd, new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						if(result.equals("success")) {
							AddPlan ap=new AddPlan(hawkeremail);
							RootPanel.get("xyz").clear();
							RootPanel.get("xyz").add(ap);
							}
							else
							{
								new MaterialToast().toast(result, 1000);
							}
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.toString());
						
					}
				});
				

				
			}
		});
	}

}
