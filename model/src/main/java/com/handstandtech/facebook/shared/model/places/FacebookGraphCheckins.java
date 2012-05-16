package com.handstandtech.facebook.shared.model.places;

import java.io.Serializable;
import java.util.List;

import com.handstandtech.facebook.shared.model.FacebookPaging;

public class FacebookGraphCheckins implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private List<FacebookGraphCheckin> data;
	private FacebookPaging paging;

	public FacebookGraphCheckins() {
		super();
	}

	public List<FacebookGraphCheckin> getData() {
		return data;
	}

	public void setData(List<FacebookGraphCheckin> data) {
		this.data = data;
	}

	public void setPaging(FacebookPaging paging) {
		this.paging = paging;
	}

	public FacebookPaging getPaging() {
		return paging;
	}
}
