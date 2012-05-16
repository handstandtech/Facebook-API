package com.handstandtech.facebook.shared.model;

import java.io.Serializable;

public class FacebookPaging implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private String previous;
	private String next;
	
	public FacebookPaging() {
		super();
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
	
}
