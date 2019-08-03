package com.client;




import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.CommonList;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.events.ClearActiveEvent;
import gwt.material.design.client.events.ClearActiveEvent.ClearActiveHandler;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;


public class HawkerList extends Composite {

	private static HawkerListUiBinder uiBinder = GWT.create(HawkerListUiBinder.class);

	interface HawkerListUiBinder extends UiBinder<Widget, HawkerList> {
	}

	public HawkerList() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public HawkerList(String ser,String clientemail) {
		this.ser=ser;
		this.clientemail=clientemail;
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	String ser="",clientemail="";
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	
	int i,n;
	@UiField
	MaterialCollection mc;

	void setup()
	{
		
			a1.Haw(ser, new AsyncCallback<CommonList>() {

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
								String hawkeremail=ml.getText();
								HawkerInfo hi=new HawkerInfo(hawkeremail,clientemail,ser);
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
	
