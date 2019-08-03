package com.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Huckster implements EntryPoint {
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
  @Override
public void onModuleLoad() {
	  starting s=new starting();
	  RootPanel.get("xyz").clear();
	  RootPanel.get("xyz").add(s);

}
}
