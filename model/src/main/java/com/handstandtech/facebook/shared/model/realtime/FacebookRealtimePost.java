package com.handstandtech.facebook.shared.model.realtime;

import java.io.Serializable;
import java.util.List;

public class FacebookRealtimePost implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private String object;
	private List<FacebookRealtimeEntry> entry;

	public FacebookRealtimePost() {
		super();
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getObject() {
		return object;
	}

	public void setEntry(List<FacebookRealtimeEntry> entry) {
		this.entry = entry;
	}

	public List<FacebookRealtimeEntry> getEntry() {
		return entry;
	}

}
