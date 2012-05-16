package com.handstandtech.facebook.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class FacebookLoggedOutEvent extends
		GwtEvent<FacebookLoggedOutEventHandler> {

	public static Type<FacebookLoggedOutEventHandler> TYPE = new Type<FacebookLoggedOutEventHandler>();

	@Override
	public Type<FacebookLoggedOutEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(FacebookLoggedOutEventHandler handler) {
		handler.onLogout(this);
	}

}
