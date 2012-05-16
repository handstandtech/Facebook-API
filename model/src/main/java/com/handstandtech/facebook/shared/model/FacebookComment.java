package com.handstandtech.facebook.shared.model;

import java.io.Serializable;

import javax.persistence.Embedded;

public class FacebookComment extends FacebookObject implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	@Embedded
	private FacebookObject from;
	
	private String message;
	
	private String created_time;

	public FacebookComment() {
		super();
	}

	public FacebookObject getFrom() {
		return from;
	}

	public void setFrom(FacebookObject from) {
		this.from = from;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
}
