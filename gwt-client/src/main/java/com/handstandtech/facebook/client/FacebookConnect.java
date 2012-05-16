package com.handstandtech.facebook.client;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.handstandtech.facebook.shared.FacebookConstants;
import com.handstandtech.facebook.shared.model.FacebookPermission;

/**
 * Class that wraps the facebook conncet API. Here you will find the javascripts
 * that requires the users interactions.
 * 
 * @see http://wiki.developers.facebook.com/index.php/JS_API_T_FB.Connect
 */
public class FacebookConnect {

	private static List<FacebookPermission> permissions = new ArrayList<FacebookPermission>();

	/**
	 * Define a javascript function wich is called by facebook when a user logs
	 * in.
	 * 
	 * @param callback
	 */
	public static native void logoutNative(OnSuccessCallback callback) /*-{
		$wnd.FB.logout(function(response) {
		// user is now logged out
		//		alert('user is now logged out');
		});
	}-*/;

	public static void login(final AsyncCallback<FacebookSession> callback) {
		AsyncCallback<FacebookSession> nativeCallback = new AsyncCallback<FacebookSession>() {
			public void onFailure(Throwable t) {
				Window.alert("CURRENTLY NO SESSION!");
			}

			public void onSuccess(FacebookSession jv) {
				callback.onSuccess(jv);
			}
		};		

		StringBuilder permList = new StringBuilder();
		permList.append("{perms: '");
		int count = 0;
		for (FacebookPermission p : permissions) {
			permList.append(p.name());
			if(count<permissions.size()-1){
				permList.append(",");
			}
			count++;
		}
		
		permList.append("'}");
		Log.debug("Logging in with permList: " + permList.toString());
		loginNative(nativeCallback, permList.toString());
	}

	private static native void loginNative(AsyncCallback callback, String permsJSON) /*-{
		$wnd.FB.login(function(response) {
		if (response.session) {

			//If we have a callback, lets send the session there!
			if(callback!=null) {
			@com.handstandtech.client.callback.JSONPCallback::callbackOnSuccessResponse(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response.session);
			}


			//TODO: Handler PERMISSIONS THAT WE RECEIVED!
			if (response.perms) {
			// user is logged in and granted some permissions.
			// perms is a comma separated list of granted permissions
			} else {
			// user is logged in, but did not grant any permissions
			}
		} else {
			// user is not logged in
		}
		}, eval('(' + permsJSON + ')'));//{perms: 'read_stream'});
	}-*/;

	public static void subscribeToLoginEvent(final AsyncCallback<FacebookSession> callback) {
		subscribeToEvent("auth.login", callback);
	}

	public static void subscribeToLogoutEvent(final AsyncCallback<FacebookSession> callback) {
		subscribeToEvent("auth.logout", callback);
	}

	public static void subscribeToSessionChangeEvent(final AsyncCallback<FacebookSession> callback) {
		subscribeToEvent("auth.sessionChange", callback);
	}

	public static void subscribeToStatusChangeEvent(final AsyncCallback<FacebookSession> callback) {
		subscribeToEvent("auth.statusChange", callback);
	}

	/**
	 * Tell facebook where to find xdreceiver.htm
	 * 
	 * @param apiKey
	 * @param xdReceiver
	 */
	public static native void subscribeToEvent(final String eventName, final AsyncCallback<FacebookSession> callback)/*-{
		$wnd.FB.Event.subscribe(eventName, function(response) {
		var result = new Boolean(true);
		@com.handstandtech.client.callback.JSONPCallback::callbackOnSuccessResponse(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response.session);
		});
	}-*/;

	/**
	 * Called when a user successfully logs in.
	 */
	public static void onLoginProxy(OnSuccessCallback callback) {
		if (callback != null) {
			callback.onSuccess();
		}
	}

	/**
	 * Setup facebook connect, let facebook know where we put xd receiver etc.
	 * 
	 * @param apiKey
	 */
	public static void init(String apiKey) {
		JSONObject apiKeyJSON = new JSONObject();
		apiKeyJSON.put(FacebookConstants.FACEBOOK_ALPHA_API_KEY, new JSONString(apiKey));
		initNative(apiKeyJSON.getJavaScriptObject());
	}

	/**
	 * Tell facebook where to find xdreceiver.htm
	 * 
	 * @param apiKey
	 * @param xdReceiver
	 */
	public static native void initNative(JavaScriptObject apiKeyObj)/*-{
		$wnd.FB.init(apiKeyObj);
	}-*/;

	public static void parseXFBML() {
		Log.debug("parseXFBML");
		parseXFBMLNative();
	}

	private static native void parseXFBMLNative()/*-{
		$wnd.FB.XFBML.parse();
	}-*/;

	public static native void parseXFBML(JavaScriptObject domElement)/*-{
		$wnd.FB.XFBML.parse(domElement);
	}-*/;

	/**
	 * Tell facebook where to find xdreceiver.htm
	 * 
	 * @param apiKey
	 * @param xdReceiver
	 */
	public static native void getLoginStatusNative(final AsyncCallback<FacebookSession> callback)/*-{
		$wnd.FB.getLoginStatus(function(response) { 
		if(callback!=null){
		var result = new Boolean(true);
		@com.handstandtech.client.callback.JSONPCallback::callbackOnSuccessResponse(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response.session);
		}
		}
		);
	}-*/;

	public static native void checkLoginStatusNative()/*-{
		$wnd.FB.getLoginStatus(function(response) { 
		//DO NOTHING, CHECKING AND WILL FIRE LISTENERS
		}
		);
	}-*/;

	public static native FacebookSession getSessionNative()/*-{
		return $wnd.FB.getSession();
	}-*/;

	public static void doQuery(final String queryString, final AsyncCallback<JavaScriptObject> callback) {

		// {
		// method: 'fql.query',
		// query: 'SELECT name, pic FROM profile WHERE id=' +
		// FB.getSession().uid
		// }

		FacebookApiCall call = FacebookApiCall.create();
		call.setMethodName("fql.query");
		call.addKeyValue("query", queryString);
		AsyncCallback<JavaScriptObject> nativeCallback = new AsyncCallback<JavaScriptObject>() {
			public void onFailure(Throwable t) {
				Window.alert("CURRENTLY NO SESSION!");
			}

			public void onSuccess(JavaScriptObject jv) {
				callback.onSuccess(jv);
			}
		};

		Log.debug("Calling Native API with: " + new JSONObject(call));
		callApiNative(call, nativeCallback);
	}

	public static native void callApiNative(FacebookApiCall call, final AsyncCallback<JavaScriptObject> callback)/*-{
		// if we have a session, query for the user's profile picture and name
		$wnd.FB.api(call, function(response) { 
		if(callback!=null){
		var result = new Boolean(true);
		@com.handstandtech.client.callback.JSONPCallback::callbackOnSuccessResponse(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		}
		}
		);
	}-*/;

	public static void getLoginStatus(final AsyncCallback<FacebookSession> callback) {

		AsyncCallback<FacebookSession> nativeCallback = new AsyncCallback<FacebookSession>() {
			public void onFailure(Throwable t) {
				Window.alert("CURRENTLY NO SESSION!");
			}

			public void onSuccess(FacebookSession jv) {
				callback.onSuccess(jv);
			}
		};
		getLoginStatusNative(nativeCallback);
	}

	/**
	 * Get the Image Source for a facebook user's image.
	 * 
	 * @param uid
	 *            The ID of the facebook user
	 * 
	 * @return The SRC for the image
	 */
	public static String getSmallImageSrc(String uid) {
		return "http://graph.facebook.com/" + uid + "/picture";
	}

	/**
	 * Get the LARGE (~200 by X) Image Source for a facebook user's image.
	 * 
	 * @param uid
	 *            The ID of the facebook user
	 * 
	 * @return The SRC for the image
	 */
	public static String getLargeImageSrc(String uid) {
		return "http://graph.facebook.com/" + uid + "/picture?type=large";
	}

	/**
	 * Create a link to a user's profile.
	 * 
	 * @param uid
	 *            The ID of the Facebook user.
	 * 
	 * @return The HREF to the user's profile.
	 */
	public static String getProfileLink(String uid) {
		return "http://www.facebook.com/profile.php?id=" + uid;
	}

	public static void setPermissions(List<FacebookPermission> perms) {
		permissions=perms;
	}

}
