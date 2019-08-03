package com.client;

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
import com.shared.HawkerDetails;
import com.shared.PlanRequest;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRadioButton;

public class AdminHawkerInfo extends Composite {

	private static AdminHawkerInfoUiBinder uiBinder = GWT.create(AdminHawkerInfoUiBinder.class);

	interface AdminHawkerInfoUiBinder extends UiBinder<Widget, AdminHawkerInfo> {
	}

	public AdminHawkerInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	public AdminHawkerInfo(String hawkeremail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=hawkeremail;
		setup();
	}
String hawkeremail="";
@UiField
MaterialLabel lblName;
@UiField
MaterialLink lblEmail;
@UiField
MaterialLink lblNumber;
@UiField
MaterialLink lblAddress;
@UiField
MaterialLink rb1;
@UiField
MaterialLink rb2;
@UiField
MaterialLink rb3;
@UiField
MaterialButton rem;
@UiField
MaterialImage imgProfile;
@UiField
MaterialIcon btnCloseProfile;
GreetingServiceAsync a1=GWT.create(GreetingService.class);
void setup()
{
	btnCloseProfile.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			AllHawkersList ahl=new AllHawkersList();
			RootPanel.get("xyz").clear();
			RootPanel.get("xyz").add(ahl);
			
			
		}
	});
	imgProfile.setPixelSize(200, 200);
	a1.hawkerDetails(hawkeremail, new AsyncCallback<HawkerDetails>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
		

		@Override
		public void onSuccess(HawkerDetails result) {
			lblName.setText(result.getName());
			lblAddress.setText(result.getAddress());
			lblNumber.setText(result.getPhone());
			lblEmail.setText(result.getEmail());
			rb1.setText("Milk "+result.getMilkprice());
			rb2.setText("Newspaper "+result.getNewspaperprice());
			rb3.setText("Combo "+result.getComboprice());
		}
	});
	
	rem.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			a1.removeHawker(hawkeremail, new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(String result) {
					if(result.equals("success"))
					{
						Window.alert("Success");
					}
					AllHawkersList adl=new AllHawkersList();
					RootPanel.get("xyz").clear();
					RootPanel.get("xyz").add(adl);
					
				}
			});
		}
		

		
	});

}
}
