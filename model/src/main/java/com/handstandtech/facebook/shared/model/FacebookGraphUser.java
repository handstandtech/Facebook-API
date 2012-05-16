package com.handstandtech.facebook.shared.model;

import java.io.Serializable;
import java.util.List;

import com.handstandtech.facebook.shared.model.profile.FacebookEducation;
import com.handstandtech.facebook.shared.model.profile.FacebookWork;

public class FacebookGraphUser extends FacebookUser implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private String first_name;
	private String last_name;
	private String link;
	private String about;
	private String birthday;
	private FacebookObject hometown;
	private FacebookObject location;
	private String quotes;
	private List<FacebookWork> work;
	private List<FacebookEducation> education;
	private String gender;
	private List<String> interested_in;
	private List<String> meeting_for;
	private String relationship_status;
	private FacebookObject significant_other;
	private String website;
	private int timezone;
	private String locale;
	private boolean verified;
	private String updated_time;

	public FacebookGraphUser() {

	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public FacebookObject getHometown() {
		return hometown;
	}

	public void setHometown(FacebookObject hometown) {
		this.hometown = hometown;
	}

	public FacebookObject getLocation() {
		return location;
	}

	public void setLocation(FacebookObject location) {
		this.location = location;
	}

	public String getQuotes() {
		return quotes;
	}

	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}

	public List<FacebookWork> getWork() {
		return work;
	}

	public void setWork(List<FacebookWork> work) {
		this.work = work;
	}

	public List<FacebookEducation> getEducation() {
		return education;
	}

	public void setEducation(List<FacebookEducation> education) {
		this.education = education;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getInterested_in() {
		return interested_in;
	}

	public void setInterested_in(List<String> interested_in) {
		this.interested_in = interested_in;
	}

	public List<String> getMeeting_for() {
		return meeting_for;
	}

	public void setMeeting_for(List<String> meeting_for) {
		this.meeting_for = meeting_for;
	}

	public String getRelationship_status() {
		return relationship_status;
	}

	public void setRelationship_status(String relationship_status) {
		this.relationship_status = relationship_status;
	}

	public FacebookObject getSignificant_other() {
		return significant_other;
	}

	public void setSignificant_other(FacebookObject significant_other) {
		this.significant_other = significant_other;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}

}
