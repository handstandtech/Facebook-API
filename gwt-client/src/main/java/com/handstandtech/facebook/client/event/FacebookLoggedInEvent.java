//package com.handstandtech.facebook.client.event;
//
//import com.google.gwt.event.shared.GwtEvent;
//import com.handstandtech.shared.model.SocialNetworkAccount;
//
//public class FacebookLoggedInEvent extends GwtEvent<FacebookLoggedInEventHandler> {
//
//    public static Type<FacebookLoggedInEventHandler> TYPE = new Type<FacebookLoggedInEventHandler>();
//	private SocialNetworkAccount account;
//
//
//    public FacebookLoggedInEvent(SocialNetworkAccount account) {
//		this.account = account;
//	}
//
//	public SocialNetworkAccount getAccount() {
//        return account;
//    }
//	
//	public void setAccount(SocialNetworkAccount account) {
//		this.account=account;
//	}
//
//      @Override
//    public Type<FacebookLoggedInEventHandler> getAssociatedType() {
//        return TYPE;
//    }
//
//    @Override
//    protected void dispatch(FacebookLoggedInEventHandler handler) {
//        handler.onLogin(this);
//    }
//
//}
