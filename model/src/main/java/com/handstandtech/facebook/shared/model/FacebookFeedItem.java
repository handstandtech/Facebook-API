package com.handstandtech.facebook.shared.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Id;

public class FacebookFeedItem extends FacebookObject {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String viewerActorItemId;

	@Embedded
	private FacebookObject from;
	private String message;
	private String description;
	private String link;
	private String picture;

	@Embedded
	private List<FacebookAction> actions;

	@Embedded
	private FacebookPrivacy privacy;
	private String type;
	private Date created_time;
	private Date updated_time;

	// @Embedded
	// private FacebookComments comments;

	private String viewerId;

	public FacebookFeedItem() {
		super();
	}

	public String createViewerActorItemId() {
		this.viewerActorItemId = getViewerId() + "-" + getActorId() + "-"
				+ getId();
		return this.viewerActorItemId;
	}

	public FacebookObject getFrom() {
		return from;
	}

	public void setFrom(FacebookObject from) {
		this.from = from;
	}

	// public FacebookComments getComments() {
	// return comments;
	// }
	//
	// public void setComments(FacebookComments comments) {
	// this.comments = comments;
	// }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FacebookAction> getActions() {
		return actions;
	}

	public void setActions(List<FacebookAction> actions) {
		this.actions = actions;
	}

	public FacebookPrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(FacebookPrivacy privacy) {
		this.privacy = privacy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		if (message != null) {
			return message;
		} else {
			return description;
		}
	}

	public Date getDate() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}

	public Date getUpdated_time() {
		return updated_time;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public String getActorId() {
		return from.getId();
	}

	public String getUserIconUrl() {
		return "https://graph.facebook.com/" + getActorId() + "/picture";
	}

	public String getUserProfileLink() {
		return "http://facebook.com/profile.php?id=" + getActorId();
	}

	public void setViewerId(String _viewerId) {
		this.viewerId = _viewerId;
	}

	public String getViewerId() {
		return this.viewerId;
	}

	public String getPhotoUrl() {
		return picture;
	}

	public String getActorName() {
		if (this.from != null) {
			return this.from.getName();
		} else {
			return null;
		}
	}

	public String getPermalink() {
		if (actions != null && !actions.isEmpty()) {
			return actions.get(0).getLink();
		} else {
			return null;
		}
	}

}
