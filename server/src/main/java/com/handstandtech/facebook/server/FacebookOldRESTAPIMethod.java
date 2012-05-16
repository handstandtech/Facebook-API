package com.handstandtech.facebook.server;

import com.handstandtech.facebook.server.util.Snippet;


public class FacebookOldRESTAPIMethod extends FacebookAPICall {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private static String BASE_URL = "https://api.facebook.com/method/";

	private String methodName;

	public FacebookOldRESTAPIMethod() {
		addParameter("format", "json");
	}

	public String getUrl() {
		return BASE_URL + getMethodName() + "?" + Snippet.getParameterString(parameters);
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}

}
