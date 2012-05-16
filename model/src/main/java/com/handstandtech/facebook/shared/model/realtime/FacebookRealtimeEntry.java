package com.handstandtech.facebook.shared.model.realtime;

import java.io.Serializable;
import java.util.List;

public class FacebookRealtimeEntry implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private String uid;
	private List<String> changed_fields;
	private Long time;

	public FacebookRealtimeEntry() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<String> getChanged_fields() {
		return changed_fields;
	}

	public void setChanged_fields(List<String> changed_fields) {
		this.changed_fields = changed_fields;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

}
