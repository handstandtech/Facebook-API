package com.handstandtech.facebook.shared.model;

import java.io.Serializable;
import java.util.List;

public class FacebookTags implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;
	
	private List<FacebookObject> data;

	public FacebookTags() {
		super();
	}

	public List<FacebookObject> getData() {
		return data;
	}

	public void setData(List<FacebookObject> data) {
		this.data = data;
	}
}
