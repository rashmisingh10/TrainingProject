package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.PaymentDetails;

public class Payment extends Composite {

	private static PaymentUiBinder uiBinder = GWT.create(PaymentUiBinder.class);

	interface PaymentUiBinder extends UiBinder<Widget, Payment> {
	}

	public Payment() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	 GreetingServiceAsync a1=GWT.create(GreetingService.class);
	@UiField
	VerticalPanel vp;
	void setup()
	{
		FlexTable ft=new FlexTable();
		Label l1=new Label("Total Payment:");
		Label l2=new Label("Number of Days Excluded:");
		Label l3=new Label();
		Label l4=new Label();
		Label l5=new Label("Total Effective Cost:");
		Label l6=new Label();
		vp.setSize("100%", "100%");
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		ft.setWidget(0, 0, l1);
		ft.setWidget(1, 0, l2);
		ft.setWidget(0, 1, l3);
		ft.setWidget(1, 1, l4);
		ft.setWidget(2, 0, l5);
		ft.setWidget(2, 1, l6);
		ft.setCellSpacing(10);
		vp.add(ft); 
		a1.pay(new AsyncCallback<PaymentDetails>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(PaymentDetails result) {
				int mc=result.getMonthlycost();
				int days=result.getDays();
				int effcost=mc-(mc/30)*days;
				l3.setText(Integer.toString(mc));
				l4.setText(Integer.toString(days));
				l6.setText(Integer.toString(effcost));
			}
		
		});
		
	}

}
