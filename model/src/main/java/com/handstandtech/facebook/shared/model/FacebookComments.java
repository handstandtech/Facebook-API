package com.handstandtech.facebook.shared.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;

public class FacebookComments implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;
	
	@Embedded
	private List<FacebookComment> data;
	
	private Integer count;

	public FacebookComments() {
		super();
	}

	public void setData(List<FacebookComment> data) {
		this.data = data;
	}

	public List<FacebookComment> getData() {
		return data;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}
}
