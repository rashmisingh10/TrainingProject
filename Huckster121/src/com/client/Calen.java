package com.client;
import com.shared.Cale;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;
public class Calen extends Composite {
	private static CalenUiBinder uiBinder = GWT.create(CalenUiBinder.class);
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	interface CalenUiBinder extends UiBinder<Widget, Calen> {
	}
	@UiField
	MaterialDatePicker p1;
	@UiField
	MaterialDatePicker p2;
	@UiField
	MaterialDatePicker p3;
	@UiField
	MaterialDatePicker p4;
	@UiField
	MaterialDatePicker p5;
	@UiField
	MaterialDatePicker p6;
	@UiField
	MaterialDatePicker p7;
	@UiField
	MaterialDatePicker p8;
	@UiField
	MaterialDatePicker p9;
	@UiField
	MaterialDatePicker p10;
	@UiField
	MaterialButton b1;
	@UiField
	MaterialButton b2;
	@UiField
	MaterialButton b3;
	@UiField
	MaterialButton b4;
	@UiField
	MaterialButton b5;
	@UiField
	MaterialButton b6;
	@UiField
	MaterialButton b7;
	@UiField
	MaterialButton b8;
	@UiField
	MaterialButton b9;
	@UiField
	MaterialButton b10;
	@UiField
	MaterialButton button;
	int i,k;
	public Calen() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public Calen(String hawkeremail,String clientemail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=hawkeremail;
		this.clientemail=clientemail;
		setup();
	}
	String hawkeremail="",clientemail="";
	void setup()
	{
	
		MaterialButton d[]=new MaterialButton[10];
		d[0]=b1;
		d[1]=b2;
		d[2]=b3;
		d[3]=b4;
		d[4]=b5;
		d[5]=b6;
		d[6]=b7;
		d[7]=b8;
		d[8]=b9;
		d[9]=b10;
		MaterialDatePicker p[]=new MaterialDatePicker[10];
		p[0]=p1;
		p[1]=p2;
		p[2]=p3;
		p[3]=p4;
		p[4]=p5;
		p[5]=p6;
		p[6]=p7;
		p[7]=p8;
		p[8]=p9;
		p[9]=p10;
		Date x[]=new Date[10];
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				k=0;
				for(i=0;i<10;i++)
				{
					if(p[i].getValue()!=null)
					{
						x[k++]=p[i].getValue();
					}
				}
				Cale c=new Cale();
				c.setN(k);
				c.setD(x); 
				c.setClientemail(clientemail);
				c.setHawkeremail(hawkeremail);
				a1.Cal(c, new AsyncCallback<String>() {
					@Override
					public void onSuccess(String result) {
						WelcomeClient wc=new WelcomeClient(clientemail);
						RootPanel.get("xyz").clear();
						RootPanel.get("xyz").add(wc);
					}
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
				
			}
		});
		
	}
}
