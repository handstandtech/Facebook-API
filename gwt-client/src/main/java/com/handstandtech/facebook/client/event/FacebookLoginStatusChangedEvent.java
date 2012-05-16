//package com.handstandtech.facebook.client.event;
//
//import com.google.gwt.event.shared.GwtEvent;
//import com.handstandtech.facebook.client.FacebookSession;
//
//public class FacebookLoginStatusChangedEvent extends GwtEvent<FacebookLoginStatusChangedEventHandler> {
//	public static Type<FacebookLoginStatusChangedEventHandler> TYPE = new Type<FacebookLoginStatusChangedEventHandler>();
//	private FacebookSession session;
//
//	public FacebookLoginStatusChangedEvent(FacebookSession session) {
//		this.setSession(session);
//	}
//
//	@Override
//	public Type<FacebookLoginStatusChangedEventHandler> getAssociatedType() {
//		return TYPE;
//	}
//
//	@Override
//	protected void dispatch(FacebookLoginStatusChangedEventHandler handler) {
//		handler.onLoginStatusChanged(this);
//	}
//
//	public void setSession(FacebookSession session) {
//		this.session = session;
//	}
//
//	public FacebookSession getSession() {
//		return session;
//	}
//}
