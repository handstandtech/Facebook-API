package com.handstandtech.facebook.shared.model.places;

import java.io.Serializable;

import com.handstandtech.facebook.shared.model.FacebookComments;
import com.handstandtech.facebook.shared.model.FacebookObject;
import com.handstandtech.facebook.shared.model.FacebookTags;

public class FacebookGraphCheckin extends FacebookObject implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private FacebookObject from;
	private FacebookTags tags;
	private String message;
	private FacebookPlace place;
	private FacebookObject application;
	private String created_time;
	private FacebookComments comments;

	public FacebookGraphCheckin() {
		super();
	}

	public FacebookObject getFrom() {
		return from;
	}

	public void setFrom(FacebookObject from) {
		this.from = from;
	}

	public FacebookTags getTags() {
		return tags;
	}

	public void setTags(FacebookTags tags) {
		this.tags = tags;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FacebookPlace getPlace() {
		return place;
	}

	public void setPlace(FacebookPlace place) {
		this.place = place;
	}

	public FacebookObject getApplication() {
		return application;
	}

	public void setApplication(FacebookObject application) {
		this.application = application;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public FacebookComments getComments() {
		return comments;
	}

	public void setComments(FacebookComments comments) {
		this.comments = comments;
	}

}
