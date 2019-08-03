package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AfterLogin extends Composite {

	private static AfterLoginUiBinder uiBinder = GWT.create(AfterLoginUiBinder.class);

	interface AfterLoginUiBinder extends UiBinder<Widget, AfterLogin> {
	}

	public AfterLogin() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	@UiField
	VerticalPanel vp;
	void setup()
	{
		ListBox lb=new ListBox();
		lb.setPixelSize(500, 500);
		lb.addItem("Show Assigned Hawker Details");
		lb.addItem("");
		
		
	}

}
