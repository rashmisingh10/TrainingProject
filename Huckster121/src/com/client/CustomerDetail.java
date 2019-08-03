package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CustomerDetail extends Composite {

	private static CustomerDetailUiBinder uiBinder = GWT.create(CustomerDetailUiBinder.class);

	interface CustomerDetailUiBinder extends UiBinder<Widget, CustomerDetail> {
	}

	public CustomerDetail() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
  @UiField
  VerticalPanel vp;
  void setup()
  {
	  FlexTable ft=new FlexTable();
	  Label l1=new Label();
	  Label l2=new Label();
	  Label l3=new Label();
	  Label l4=new Label();
	  
	  TextBox t1=new TextBox();
	  TextBox t2=new TextBox();
	  TextBox t3=new TextBox();
	  TextBox t4=new TextBox();
	  
	  l1.setText("Phone no");
	  l2.setText("Address");
	  l3.setText("Monthly Plan");
	  l4.setText("Total Payment");
	  
	  ft.setWidget(0, 0, l1);
	  ft.setWidget(0, 1, t1);
	  ft.setWidget(1, 0, l2);
	  ft.setWidget(1, 1, t2);
	  ft.setWidget(2, 0, l3);
	  ft.setWidget(2, 1, t3);
	  ft.setWidget(3, 0, l4);
	  ft.setWidget(3, 1, t4);
	  
	  
	  VerticalPanel vp=new VerticalPanel();
	  vp.setWidth("100%");
	  vp.setHeight("100%");
	  vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	  vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	  vp.setSpacing(20);
	  vp.add(ft);
	  String name="customer 1";
	 
  }
}
