package com.handstandtech.facebook.server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class FacebookAPICall implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Map<String, String> parameters = new HashMap<String, String>();

	public abstract String getUrl();

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public void addParameter(String key, String value) {
		this.parameters.put(key, value);
	}
}
