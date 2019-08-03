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
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialLink;

public class AllHawkersList extends Composite {

	private static AllHawkersListUiBinder uiBinder = GWT.create(AllHawkersListUiBinder.class);

	interface AllHawkersListUiBinder extends UiBinder<Widget, AllHawkersList> {
	}

	public AllHawkersList() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public AllHawkersList(String ser) {
		this.ser=ser;
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	String ser="";
	int i,n;
	@UiField
	MaterialButton b2;
	@UiField
	MaterialCollection mc;
	void setup()
	{
		b2.setText("Back");
		b2.setPixelSize(300, 30);
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				WelcomeAdmin wa=new WelcomeAdmin();
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(wa);
				
			}
		});
		a1.AllHaw(ser, new AsyncCallback<CommonList>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(CommonList result) {
				n=result.getN();
				String x[]=new String[n];
				x=result.getC();
				for(i=0;i<n;i++)
				{
					MaterialCollectionItem mci=new MaterialCollectionItem();
					MaterialLink ml=new MaterialLink(x[i]);
					ml.setTextColor(Color.BLACK);
					mci.add(ml);
					mc.add(mci);
					mci.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							String x=ml.getText();
							AdminHawkerInfo hi=new AdminHawkerInfo(x);
							RootPanel.get("xyz").clear();
							RootPanel.get("abc").clear();
							RootPanel.get("cde").clear();
							RootPanel.get("xyz").add(hi);
							
						}
					});
				}
				
			}
		});
	}
}
