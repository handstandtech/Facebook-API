package com.handstandtech.facebook.client;

import com.google.gwt.core.client.JavaScriptObject;

public class FacebookPhotoTag extends JavaScriptObject {

	protected FacebookPhotoTag() {
	}

	public final native String getId() /*-{
		return this.id;
	}-*/;

	public final native String getName() /*-{
		return this.name;
	}-*/;

}
