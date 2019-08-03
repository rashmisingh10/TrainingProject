package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.planDetails;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class AddPlan extends Composite {

	private static AddPlanUiBinder uiBinder = GWT.create(AddPlanUiBinder.class);

	interface AddPlanUiBinder extends UiBinder<Widget, AddPlan> {
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);

	public AddPlan() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public AddPlan(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=email;
		setup();
	}
	String hawkeremail="";
	@UiField
	MaterialTextBox t1;
	@UiField
	MaterialTextBox t2;
	@UiField
	MaterialTextBox t3;
	@UiField
	MaterialTextBox t4;
	@UiField
	MaterialTextBox t5;
	@UiField
	MaterialTextBox t6;
	@UiField
	MaterialButton b;
	@UiField
	MaterialCheckBox chck1;
	@UiField
	MaterialCheckBox chck2;
	@UiField
	MaterialCheckBox chck3;
	void setup()
	{
		
	b.addClickHandler(new ClickHandler() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(ClickEvent event) {
			b.setSize("100%", "30%");
			String mpm="none",qm="none",mpn="none",mpc="none",qc="none";
			if(chck1.isChecked())
			{
				if(t1.getText().isEmpty()||t2.getText().isEmpty())
				{
					new MaterialToast().toast("Required Fields Cannot Be Empty.", 1000);
					return;
				}
				 mpm=t1.getText();
				 qm=t2.getText();
			}
			if(chck2.isChecked())
			{
				
				if(t3.getText().isEmpty())
				{
					new MaterialToast().toast("Required Fields Cannot Be Empty.", 1000);
					return;
				}
				mpn=t3.getText();
			}
			if(chck3.isChecked())
			{
				if(t5.getText().isEmpty()||t6.getText().isEmpty())
				{
					new MaterialToast().toast("Required Fields Cannot Be Empty.", 1000);
					return;
				}
				mpc=t5.getText();
				qc=t6.getText();
			}
			planDetails pd=new planDetails();
			pd.setEmail(hawkeremail);
			pd.setMpm(mpm);
			pd.setQm(qm);
			pd.setMpn(mpn);
			pd.setMpc(mpc);
			pd.setQc(qc);
			a1.plandetails(pd, new AsyncCallback<String>() {
				
				@Override
				public void onSuccess(String result) {
					WelcomeHawker w=new WelcomeHawker(hawkeremail);
					RootPanel.get("xyz").clear();
					RootPanel.get("xyz").add(w);
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Window.alert(caught.toString());
					
				}
			});
			
			
		}
	});
	}

}
