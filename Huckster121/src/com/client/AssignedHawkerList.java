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

public class AssignedHawkerList extends Composite {

	private static AssignedHawkerListUiBinder uiBinder = GWT.create(AssignedHawkerListUiBinder.class);

	interface AssignedHawkerListUiBinder extends UiBinder<Widget, AssignedHawkerList> {
	}

	public AssignedHawkerList() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public AssignedHawkerList(String clientemail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.clientemail=clientemail;
		setup();
	}
	int i,n;
	@UiField
	MaterialCollection mc;
	@UiField
	MaterialButton b1;
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	String clientemail="";
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
		a1.assignedHawkerList(clientemail, new AsyncCallback<CommonList>() {
			
			@Override
			public void onSuccess(CommonList result) {
				int n,i;
				n=result.getN();
				String a[]=new String[n];
				a=result.getC();
				for(i=0;i<n;i++)
				{
					MaterialCollectionItem mci=new MaterialCollectionItem();
					MaterialLink ml=new MaterialLink(a[i]);
					ml.setTextColor(Color.BLACK);
					mci.add(ml);
					mc.add(mci);
					mci.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							String hawkeremail=ml.getText();
							OrderDetails od=new OrderDetails(clientemail, hawkeremail);
							RootPanel.get("xyz").clear();
							RootPanel.get("xyz").add(od);
							
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
