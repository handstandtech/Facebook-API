package com.handstandtech.facebook.shared.model;

import java.util.Date;

import javax.persistence.Id;

public class FacebookPhoto extends FacebookObject {

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String pid;

	private String aid;
	private String caption;
	private Date created;
	private String src;
	private String ownerId;
	private String permalink;
	private String src_big;

	public FacebookPhoto() {
		super();
	}

	public Date getDate() {
		return created;
	}

	public String getActorId() {
		return ownerId;
	}

	public String getPhotoUrl() {
		return src;
	}

	public String getUserIconUrl() {
		return "https://graph.facebook.com/" + ownerId + "/picture";
	}

	public String getUserProfileLink() {
		return "http://facebook.com/profile.php?id=" + ownerId;
	}

	public String getText() {
		return caption;
	}

	public String getPid() {
		return pid;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public void setSrcBig(String src_big) {
		this.src_big = src_big;
	}

	public String getSrcBig() {
		return src_big;
	}

	public String getPermalink() {
		return permalink;
	}

}
