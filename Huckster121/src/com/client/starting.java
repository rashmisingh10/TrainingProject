package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;

public class starting extends Composite {

	private static startingUiBinder uiBinder = GWT.create(startingUiBinder.class);

	interface startingUiBinder extends UiBinder<Widget, starting> {
	}
	@UiField
	MaterialButton b1;
	@UiField
	MaterialButton b2;
	@UiField
	MaterialButton b3;
	
	
	
	public starting() {
		initWidget(uiBinder.createAndBindUi(this));

	}
	@UiHandler("b1")
	public void onClickClient(ClickEvent e)
	{
		ClientLogin cl=new ClientLogin();
		RootPanel.get("xyz").clear();
		RootPanel.get("xyz").add(cl);
		
	}
	@UiHandler("b2")
	public void onClickHawker(ClickEvent e)
	{
		HawkerLogin hl=new HawkerLogin();
		RootPanel.get("xyz").clear();
		RootPanel.get("xyz").add(hl);
	}
	@UiHandler("b3")
	public void onClickAdmin(ClickEvent e)
	{
		AdminLogin al=new AdminLogin();
		RootPanel.get("xyz").clear();
		RootPanel.get("xyz").add(al);
	}
	
	

}
