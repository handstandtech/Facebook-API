package com.handstandtech.facebook.shared.model.profile;

import java.io.Serializable;
import java.util.List;

import com.handstandtech.facebook.shared.model.FacebookObject;

public class FacebookEducation implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private FacebookObject school;
	private FacebookObject year;
	private List<FacebookObject> concentration;
	private String type;

	public FacebookEducation() {

	}

	public FacebookObject getSchool() {
		return school;
	}

	public void setSchool(FacebookObject school) {
		this.school = school;
	}

	public FacebookObject getYear() {
		return year;
	}

	public void setYear(FacebookObject year) {
		this.year = year;
	}

	public List<FacebookObject> getConcentration() {
		return concentration;
	}

	public void setConcentration(List<FacebookObject> concentration) {
		this.concentration = concentration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
