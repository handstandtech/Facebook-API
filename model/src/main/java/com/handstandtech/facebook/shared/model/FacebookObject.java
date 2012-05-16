package com.handstandtech.facebook.shared.model;

import java.io.Serializable;

public class FacebookObject implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public FacebookObject() {

	}

	public FacebookObject(String id) {
		this.id = id;
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
