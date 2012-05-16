package com.handstandtech.facebook.shared.model;

import java.io.Serializable;

public class FacebookPrivacy implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private String description;
	private String value;
	
	public FacebookPrivacy() {
		super();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
