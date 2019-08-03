package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Welcome extends Composite  {

	private static WelcomeUiBinder uiBinder = GWT.create(WelcomeUiBinder.class);

	interface WelcomeUiBinder extends UiBinder<Widget, Welcome> {
	}

	public Welcome() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button b1;
	
	@UiField
	Button b2;
	
	@UiField
	Button b3;

	
	@UiHandler("b1")
	void onClick2(ClickEvent e) {
		
		b1.setText("Show Existing Customers");
		b1.setPixelSize(550, 50);
	}
		
		@UiHandler("b2")
		void onClick(ClickEvent e) {
		b2.setText(" Change Existing Plan");
		b2.setPixelSize(550, 50);
		}
		
		
		@UiHandler("b3")
		void onClick1(ClickEvent e) {
		b3.setText(" Show Customer's Request");
		b3.setPixelSize(550, 50);
		}
	}



