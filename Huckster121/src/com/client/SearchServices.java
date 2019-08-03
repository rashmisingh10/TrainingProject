package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.events.SearchFinishEvent;
import gwt.material.design.client.ui.*;


public class SearchServices extends Composite {

	private static SearchServicesUiBinder uiBinder = GWT.create(SearchServicesUiBinder.class);

	interface SearchServicesUiBinder extends UiBinder<Widget, SearchServices> {
	}
	
	
	@UiField
	MaterialButton b2;
	@UiField
	MaterialSearch t1;
	@UiField
	MaterialPanel m;
	
	
	
	
	
	public SearchServices(String clientemail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.clientemail=clientemail;
		setup();
	}
	public SearchServices()
	{
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	
	String clientemail="";
	
	void setup()
	{
	// mp.setSize("80%", "30%");
		RootPanel.get("cde").clear();
		RootPanel.get("cde").add(m);
		b2.setPixelSize(300, 30);
		
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				
					WelcomeClient wc=new WelcomeClient(clientemail);
					RootPanel.get("xyz").clear();;
					RootPanel.get("abc").clear();;
					RootPanel.get("cde").clear();;
					RootPanel.get("xyz").add(wc);;
				
			}
		});
	
	
		t1.addCloseHandler(new CloseHandler<String>() {
			
			@Override
			public void onClose(CloseEvent<String> event) {
				t1.setText(null);
				
			}
		});
		t1.getIconSearch().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {				
				String ser=t1.getText();
				HawkerList hl=new HawkerList(ser,clientemail);
				RootPanel.get("abc").clear();
				RootPanel.get("abc").add(hl);
			}
		});
	}

}
