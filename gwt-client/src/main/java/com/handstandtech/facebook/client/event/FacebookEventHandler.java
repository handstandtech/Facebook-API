//package com.handstandtech.facebook.client.event;
//import com.allen_sauer.gwt.log.client.Log;
//import com.google.gwt.json.client.JSONObject;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.handstandtech.facebook.client.FacebookConnect;
//import com.handstandtech.facebook.client.FacebookSession;
//import com.handstandtech.facebook.shared.FacebookConstants;
//import com.handstandtech.shared.model.HandstandTechAppType;
//import com.handstandtech.shared.model.ReleaseConstants;
//
//public class FacebookEventHandler {
//	private EventBus eventBus;
//
//	public FacebookEventHandler(EventBus eventBus, HandstandTechAppType appType) {
//		this.eventBus = eventBus;
//		doFacebookInit(appType);
//	}
//
//	private void doFacebookInit(HandstandTechAppType appType) {
//		// if (!initialized) {
//		Log.debug("doFacebookInit fromCenterContainerPResenter");
//
//		String hostname = Window.Location.getHostName().toLowerCase();
//		Log.debug("Request came from Hostname : " + Window.Location.getHostName());
//
//		// Devleopment Mode
//		if (hostname.indexOf("localhost") != -1 || hostname.indexOf("127.0.0.1") != -1) {
//			ReleaseConstants.RELEASE_MODE = false;
//			Log.debug("Calling Init FB DEVELOPMENT: " + FacebookConstants.DEVELOPMENT_API_KEY);
//			FacebookConnect.init(FacebookConstants.DEVELOPMENT_API_KEY);
//
//		}
//		// Release mode
//		else {
//			ReleaseConstants.RELEASE_MODE = true;
//			String apiKey = getCorrectReleaseAPIKey(appType, hostname);
//		
//			FacebookConnect.init(apiKey);
//
//		}
//
//		FacebookConnect.getLoginStatusNative(new GetLoginStatusCallback());
//
//		// Check Login Status
//		FacebookConnect.subscribeToSessionChangeEvent(new AsyncCallback<FacebookSession>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//
//			}
//
//			@Override
//			public void onSuccess(FacebookSession session) {
//				// if(session!=null) {
//				JSONObject json = new JSONObject(session);
//				Log.debug("Session Changed: " + json.toString());
//				Log.debug("New Event: " + json.toString());
//				eventBus.fireEvent(new FacebookLoginStatusChangedEvent(session));
//			}
//		});
//
//	}
//
//	private String getCorrectReleaseAPIKey(HandstandTechAppType appType, String hostname) {
//		switch (appType) {
//		case VISIT_MY_FRIENDS:
//			if (hostname.toLowerCase().indexOf("visitmyfriends") != -1) {
//				return FacebookConstants.VISITMYFRIENDS_RELEASE_API_KEY;
//			} else if (hostname.toLowerCase().indexOf("bntown") != -1) {
//				return FacebookConstants.BNTOWN_RELEASE_API_KEY;
//			} else if (hostname.toLowerCase().indexOf("myfriendmap") != -1) {
//				return FacebookConstants.MYFRIENDMAP_RELEASE_API_KEY;
//			}else {
//				Log.error("Unrecognized host: " + hostname);
//			}
//			break;
//		case PHOTOS_TOGETHER:
//			return FacebookConstants.PHOTOSTOGETHER_RELEASE_API_KEY;
//		case MY_FRIEND_MAP:
//			return FacebookConstants.MYFRIENDMAP_RELEASE_API_KEY;
//		case SOCIAL_USAGE:
//			return FacebookConstants.SOCIALUSAGE_RELEASE_API_KEY;
//		}
//		return null;
//
//	}
//
//	private class GetLoginStatusCallback implements AsyncCallback<FacebookSession> {
//		public void onFailure(Throwable caught) {
//			Log.error("Failed GetLoginStatusCallback");
//		}
//
//		public void onSuccess(FacebookSession session) {
//			Log.debug("Success GetLoginStatusCallback");
//			// Window.alert("Got session after init... " + new
//			// JSONObject(session).toString());
//			// eventBus.fireEvent(new FacebookLoginStatusChangedEvent(session));
//			// handleFacebookSession(session);
//			// FacebookConnect
//			// .subscribeToSessionChangeEvent(new OnSessionChangeCallback());
//		}
//	};
//}
