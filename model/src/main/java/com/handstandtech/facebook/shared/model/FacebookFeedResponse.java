package com.handstandtech.facebook.shared.model;

import java.io.Serializable;
import java.util.List;

public class FacebookFeedResponse implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private List<FacebookFeedItem> data;
	private FacebookPaging paging;

	public FacebookFeedResponse() {
		super();
	}

	public List<FacebookFeedItem> getData() {
		return data;
	}

	public void setData(List<FacebookFeedItem> data) {
		this.data = data;
	}

	public void setPaging(FacebookPaging paging) {
		this.paging = paging;
	}

	public FacebookPaging getPaging() {
		return paging;
	}
}
