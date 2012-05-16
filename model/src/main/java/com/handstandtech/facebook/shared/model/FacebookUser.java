package com.handstandtech.facebook.shared.model;

import java.io.Serializable;

public class FacebookUser implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;

	public FacebookUser() {

	}

	public FacebookUser(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
