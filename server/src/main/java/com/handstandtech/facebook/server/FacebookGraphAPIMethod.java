package com.handstandtech.facebook.server;

public class FacebookGraphAPIMethod extends FacebookAPICall {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private static final String BASE_URL = "https://graph.facebook.com/";

	public FacebookGraphAPIMethod() {
		
	}
	
	public String getUrl() {
		return BASE_URL;
	}
}
