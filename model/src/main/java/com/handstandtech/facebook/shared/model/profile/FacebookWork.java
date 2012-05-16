package com.handstandtech.facebook.shared.model.profile;

import java.io.Serializable;

import com.handstandtech.facebook.shared.model.FacebookObject;

public class FacebookWork implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private FacebookObject employer;
	private FacebookObject location;
	private FacebookObject position;
	private String start_date;
	private String end_date;
	private String description;

	public FacebookWork() {

	}

	public FacebookObject getEmployer() {
		return employer;
	}

	public void setEmployer(FacebookObject employer) {
		this.employer = employer;
	}

	public FacebookObject getLocation() {
		return location;
	}

	public void setLocation(FacebookObject location) {
		this.location = location;
	}

	public FacebookObject getPosition() {
		return position;
	}

	public void setPosition(FacebookObject position) {
		this.position = position;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
