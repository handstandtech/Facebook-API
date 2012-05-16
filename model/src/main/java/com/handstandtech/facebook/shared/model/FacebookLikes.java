package com.handstandtech.facebook.shared.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;

public class FacebookLikes implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	@Embedded
	private List<FacebookObject> data;

	private Integer count;

	public FacebookLikes() {

	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setData(List<FacebookObject> data) {
		this.data = data;
	}

	public List<FacebookObject> getData() {
		return data;
	}

}
