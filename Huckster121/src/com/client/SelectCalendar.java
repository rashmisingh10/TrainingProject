package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SelectCalendar extends Composite {

	private static SelectCalendarUiBinder uiBinder = GWT.create(SelectCalendarUiBinder.class);

	interface SelectCalendarUiBinder extends UiBinder<Widget, SelectCalendar> {
	}

	public SelectCalendar() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	@UiField
	HorizontalPanel hp;
	void setup()
	{
		TextBox t1=new TextBox();
		TextBox t2=new TextBox();
		Label l1=new Label("Month");
		Label l2=new Label("Year");
		Button b=new Button("Submit");
		hp.add(l1);
		hp.add(t1);
		hp.add(l2);
		hp.add(t2);
		hp.add(b);
		b.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int month=Integer.parseInt(t1.getText());
				int year=Integer.parseInt(t2.getText());
				if((year%400==0)||(year%100!=0&&year%400!=0&&year%4==0))
				{
					if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
					{
						Calendar c=new Calendar();
						RootPanel.get("abc").clear();
						RootPanel.get("abc").add(c);
					}
					else if(month==2)
					{
						Calendar29 c=new Calendar29();
						RootPanel.get("abc").clear();
						RootPanel.get("abc").add(c);
					}
					else
					{
						Calender30 c=new Calender30();
						RootPanel.get("abc").clear();
						RootPanel.get("abc").add(c);
						
					}
				}
				else
				{
					if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
					{
						Calendar c=new Calendar();
						RootPanel.get("abc").clear();
						RootPanel.get("abc").add(c);
					}
					else if(month==2)
					{
						Calendar28 c=new Calendar28();
						RootPanel.get("abc").clear();
						RootPanel.get("abc").add(c);
					}
					else
					{
						Calender30 c=new Calender30();
						RootPanel.get("abc").clear();
						RootPanel.get("abc").add(c);
						
					}
				}
				
			}
		});
		
		
	}

}
