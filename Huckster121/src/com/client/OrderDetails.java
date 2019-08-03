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
import com.shared.Assignedhawkerdetails;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.ModalType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialModalContent;
import gwt.material.design.client.ui.MaterialModalFooter;
import gwt.material.design.client.ui.MaterialPanel;

public class OrderDetails extends Composite {

	private static OrderDetailsUiBinder uiBinder = GWT.create(OrderDetailsUiBinder.class);

	interface OrderDetailsUiBinder extends UiBinder<Widget, OrderDetails> {
	}

	public OrderDetails() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public OrderDetails(String clientemail,String hawkeremail) {
			initWidget(uiBinder.createAndBindUi(this));
			this.clientemail=clientemail;
			this.hawkeremail=hawkeremail;
			setup();
	}
	@UiField
	MaterialButton b1,pay;
	@UiField
	MaterialLabel l1,l2,l3,l4,l5,l6;
	@UiField
	MaterialPanel mp;
	
	int n;
	String clientemail,hawkeremail,plancost;
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	void setup()
	{
		l1.setFontSize("2em");
		l2.setFontSize("2em");
		l3.setFontSize("2em");
		l4.setFontSize("2em");
		l5.setFontSize("2em");
		l6.setFontSize("2em");
		
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AssignedHawkerList ahl=new AssignedHawkerList(clientemail);
				RootPanel.get("xyz").clear();
				RootPanel.get("xyz").add(ahl);
				
			}
		});
		
		a1.assignedHawker(hawkeremail,clientemail,new AsyncCallback<Assignedhawkerdetails>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Assignedhawkerdetails result) {
				l1.setText("Hawker Name: "+result.getName());
				l2.setText("Hawker Email: "+result.getEmail());
				l3.setText("Hawker Phone: "+result.getPhone());
				l4.setText("Hawker Address: "+result.getAddress());
				l5.setText("Service Chosen: "+result.getService());
				l6.setText("Monthly Plan Cost: "+result.getMonthlyplan());
				plancost=result.getMonthlyplan();
				n=result.getN();
				MaterialLabel l10[]=new MaterialLabel[n];
				String x[]=new String[n];
				x=result.getLeave();
				for(int i=0;i<n;i++)
				{ 
					l10[i]=new MaterialLabel();
					l10[i].setText(x[i]);
					l10[i].setFontSize("2em");
					mp.add(l10[i]);
				}
			}
			
		});
		MaterialModal mm=new MaterialModal();
		MaterialModalContent mmc=new MaterialModalContent();
		MaterialLabel n1=new MaterialLabel();
		MaterialLabel n2=new MaterialLabel();
		MaterialLabel n3=new MaterialLabel();
		MaterialLabel n4=new MaterialLabel();
		MaterialModalFooter mmf=new MaterialModalFooter();
		MaterialButton close=new MaterialButton("Close");
		pay.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				n1.setText("Total Payment: "+plancost);
				n2.setText("Days Excluded: "+n);
				double amount,effective;
				amount=(Double.parseDouble(plancost)/30)*n;
				n3.setText("Amount subtracted: "+amount);
				effective=Double.parseDouble(plancost)-amount;
				n4.setText("Total Effective Cost: "+effective);
				mmc.add(n1);
				mmc.add(n2);
				mmc.add(n3);
				mmc.add(n4);
				mm.add(mmc);
				mm.setInDuration(500);
				mm.setOutDuration(500);
				mm.setType(ModalType.DEFAULT);
				mm.setDismissible(false);
				close.setBackgroundColor(Color.WHITE);
				close.setTextColor(Color.BLACK);
				mmf.add(close);
				mm.add(mmf);
				RootPanel.get("xyz").add(mm);
				mm.open();
				close.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						mm.close();
						
					}
				});
				
	}

});
		
		
		
	}
}
