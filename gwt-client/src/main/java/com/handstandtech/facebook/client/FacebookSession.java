package com.handstandtech.facebook.client;

import com.google.gwt.core.client.JavaScriptObject;

public class FacebookSession extends JavaScriptObject {

	protected FacebookSession() {
	}

	public final native String getUid() /*-{
		return this.uid + "";
	}-*/;

	public final native String getSessionKey() /*-{
		return this.session_key;
	}-*/;

	public final native String getSecret() /*-{
		return this.secret;
	}-*/;

	public final native String getSig() /*-{
		return this.sig;
	}-*/;

	public final native int getExpires() /*-{
		return this.expires;
	}-*/;

	public final native String getAccessToken() /*-{
		return this.access_token;
	}-*/;

}
