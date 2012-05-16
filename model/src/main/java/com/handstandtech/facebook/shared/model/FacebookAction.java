package com.handstandtech.facebook.shared.model;

import java.io.Serializable;

public class FacebookAction implements Serializable {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String link;
	
	public FacebookAction() {
		super();
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
