package com.handstandtech.facebook.client;

import com.google.gwt.core.client.JavaScriptObject;

public class TaggedFacebookPhoto extends JavaScriptObject {

	protected TaggedFacebookPhoto() {
	}

	public final native String getId() /*-{
		return this.id + "";
	}-*/;

	public final native String getSmallUrl() /*-{
		return this.picture;
	}-*/;

	public final native String getLargeUrl() /*-{
		return this.source;
	}-*/;

	public final native String getCaption() /*-{
		return this.name;
	}-*/;

	public final native int getHeight() /*-{
		return this.height;
	}-*/;

	public final native int getWidth() /*-{
		return this.width;
	}-*/;

}
