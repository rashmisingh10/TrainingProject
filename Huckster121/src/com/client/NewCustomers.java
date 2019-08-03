package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
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
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialLink;

public class NewCustomers extends Composite {

	private static NewCustomersUiBinder uiBinder = GWT.create(NewCustomersUiBinder.class);

	interface NewCustomersUiBinder extends UiBinder<Widget, NewCustomers> {
	}

	public NewCustomers() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public NewCustomers(String hawkeremail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=hawkeremail;
		setup();
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	String hawkeremail="";
	@UiField
	MaterialButton b2;
	@UiField
	MaterialCollection mc;

	int n,i;

	void setup()
	{
		b2.setText("Back");
		b2.setPixelSize(300, 30);
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				WelcomeHawker wh=new WelcomeHawker(hawkeremail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(wh);
				
			}
		});
		a1.newCustomers(hawkeremail, new AsyncCallback<CommonList>() {

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
							String clientemail=ml.getText();
							NewCustomerDetail ncd=new NewCustomerDetail(clientemail,hawkeremail);
							RootPanel.get("xyz").clear();
							RootPanel.get("abc").clear();
							RootPanel.get("cde").clear();
							RootPanel.get("xyz").add(ncd);
							
						}
					});
				}
				
		
    }
		});
}
		


}
