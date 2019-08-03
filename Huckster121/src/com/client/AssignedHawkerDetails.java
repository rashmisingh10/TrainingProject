package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AssignedHawkerDetails extends Composite {

	private static AssignedHawkerDetailsUiBinder uiBinder = GWT.create(AssignedHawkerDetailsUiBinder.class);

	interface AssignedHawkerDetailsUiBinder extends UiBinder<Widget, AssignedHawkerDetails> {
	}

	public AssignedHawkerDetails(String hawkeremail) {
		initWidget(uiBinder.createAndBindUi(this));
		this.hawkeremail=hawkeremail;
		setup();
	}
	public AssignedHawkerDetails() {
		initWidget(uiBinder.createAndBindUi(this));
		setup();
	}
	
	String hawkeremail="";
	void setup()
	{
		
	}
}
