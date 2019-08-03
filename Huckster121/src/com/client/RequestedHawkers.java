package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.CommonList;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialLink;

public class RequestedHawkers extends Composite {

	private static RequestedHawkersUiBinder uiBinder = GWT.create(RequestedHawkersUiBinder.class);

	interface RequestedHawkersUiBinder extends UiBinder<Widget, RequestedHawkers> {
	}

	public RequestedHawkers() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public RequestedHawkers(String clientemail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.clientemail=clientemail;
		setup();
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	@UiField
	MaterialCollection mc;
	@UiField
	MaterialButton b1;
	String clientemail;
	int n;
	void setup()
	{
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				WelcomeClient wc=new WelcomeClient(clientemail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(wc);
				
			}
		});
		a1.getRequestedHawkers(clientemail, new AsyncCallback<CommonList>() {
			
			@Override
			public void onSuccess(CommonList result) {
				n=result.getN();
				String x[]=new String[n];
				x=result.getC();
				for(int i=0;i<n;i++)
				{
					MaterialCollectionItem mci=new MaterialCollectionItem();
					MaterialLink ml=new MaterialLink(x[i]);
					MaterialLink ml2=new MaterialLink("Request Pending");
					ml2.setTextAlign(TextAlign.RIGHT);
					ml.setTextColor(Color.BLACK);
					ml2.setTextColor(Color.RED);
					mci.add(ml);
					mci.add(ml2);
					mc.add(mci);
					mci.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							String hawkeremail=ml.getText();
							RequestedHawkerDetails rhd=new RequestedHawkerDetails(hawkeremail,clientemail);
							RootPanel.get("xyz").clear();
							RootPanel.get("abc").clear();
							RootPanel.get("cde").clear();
							RootPanel.get("xyz").add(rhd);
							
						}
					});
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	}

}
