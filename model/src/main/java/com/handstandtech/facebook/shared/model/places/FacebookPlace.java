package com.handstandtech.facebook.shared.model.places;

import java.io.Serializable;

import com.handstandtech.facebook.shared.model.FacebookAddress;
import com.handstandtech.facebook.shared.model.FacebookObject;

public class FacebookPlace extends FacebookObject implements Serializable{

	
	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;
	
	private FacebookAddress location;

	public FacebookPlace() {
		super();
	}

	public void setLocation(FacebookAddress location) {
		this.location = location;
	}

	public FacebookAddress getLocation() {
		return location;
	}
}
