package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Plan extends Composite {

	private static PlanUiBinder uiBinder = GWT.create(PlanUiBinder.class);

	interface PlanUiBinder extends UiBinder<Widget, Plan> {
	}

	public Plan() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}

	@UiField
	VerticalPanel vp;
	void setup()
	{
			CheckBox chck11=new  CheckBox("Milk");                
			CheckBox chck2=new CheckBox("Newspaper");
			CheckBox chck3=new CheckBox("Combo");
		 
		  FlexTable ft=new FlexTable();
		  Label l1=new Label();
		  Label l2=new Label();
		  Label l3=new Label();
		  Label l4=new Label();
		  Label l5=new Label();
		  Label l6=new Label();
		  l1.setStyleName("text");
		  l2.setStyleName("text");
		  l3.setStyleName("text");
		  l4.setStyleName("text");
		  l5.setStyleName("text");
		  l6.setStyleName("text");

		  TextBox t1=new TextBox();
		  TextBox t2=new TextBox();
		  TextBox t3=new TextBox();
		  TextBox t4=new TextBox();
		  TextBox t5=new TextBox();
		  TextBox t6=new TextBox();
		  t1.setStyleName("text1");
		  t2.setStyleName("text2");
		  t3.setStyleName("text1");
		  t4.setStyleName("text2");
		  t5.setStyleName("text1");
		  t6.setStyleName("text2");
		  
		  l1.setText("Monthly Price");
		  l2.setText("Quantity");
		  l3.setText("Monthly Price");
		  l4.setText("Quantity");
		  l5.setText("Monthly Price");
		  l6.setText("Quantity");
		  

	ft.setWidget(0, 0, chck11);
	ft.setWidget(1, 0, l1);
	ft.setWidget(1, 1, t1);
	ft.setWidget(2, 0, l2);
	ft.setWidget(2, 1, t2);
	ft.setWidget(3, 0, chck2);
	ft.setWidget(4, 0, l3);
	ft.setWidget(4, 1, t3);
	ft.setWidget(5, 0, l4);
	ft.setWidget(5, 1, t4);
	ft.setWidget(6, 0, chck3);
	ft.setWidget(7, 0, l5);
	ft.setWidget(7, 1, t5);
	ft.setWidget(8, 0, l6);
	ft.setWidget(8, 1, t6);
	Button b=new Button();
	b.setText("OK");
	b.setStyleName("OK");
	vp.setWidth("100%");
	vp.setHeight("100%");
	vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	vp.setSpacing(20);
	vp.add(ft);
	vp.add(b);
	
	}	
}



