//package com.handstandtech.facebook.shared;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.handstandtech.facebook.shared.model.FacebookPermission;
//import com.handstandtech.shared.model.ParamType;
//
//public class FQLTables {
//
//	public static List<FQLTable> getTables() {
//		List<FQLTable> tables = new ArrayList<FQLTable>();
//		tables.add(albumTable());
//		tables.add(applicationTable());
//		tables.add(commentTable());
//		tables.add(connectionTable());
//		tables.add(groupTable());
//		tables.add(likeTable());
//		tables.add(linkTable());
//		tables.add(linkStatTable());
//		tables.add(messageTable());
//		tables.add(metricsTable());
//		tables.add(notificationTable());
//		tables.add(photoTable());
//		tables.add(photoTagTable());
//		tables.add(profileTable());
//		tables.add(privacyTable());
//		tables.add(statusTable());
//		tables.add(streamTable());
//		tables.add(threadTable());
//		tables.add(userTable());
//		tables.add(videoTable());
//		tables.add(videoTagTable());
//		return tables;
//	}
//
//	private static FQLTable albumTable() {
//		FQLTable table = new FQLTable("album");
//		table.setDescription("Query this table to return information about a photo album.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("aid", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("owner", ParamType.INT, true));
//		table.addColumn(new FQLColumn("cover_pid", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("name", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("created", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("modified", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("description", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("location", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("size", ParamType.INT, false));
//		table.addColumn(new FQLColumn("link", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("visible", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("modified_major", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("edit_link", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("type", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("object_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("can_upload", ParamType.BOOL, false));
//		return table;
//	}
//
//	/**
//	 * Application Table
//	 */
//	private static FQLTable applicationTable() {
//		FQLTable table = new FQLTable("application");
//		table.setDescription("Query this table to return read-only properties about an application.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("app_id", ParamType.INT, true));
//		table.addColumn(new FQLColumn("api_key", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("canvas_name", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("display_name", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("icon_url", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("logo_url", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("company_name", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("developers", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("description", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("daily_active_users", ParamType.INT, false));
//		table.addColumn(new FQLColumn("weekly_active_users", ParamType.INT, false));
//		table.addColumn(new FQLColumn("monthly_active_users", ParamType.INT, false));
//		table.addColumn(new FQLColumn("category", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("subcategory", ParamType.STRING, false));
//		return table;
//	}
//
//	/**
//	 * Comment Table
//	 */
//	private static FQLTable commentTable() {
//		FQLTable table = new FQLTable("comment");
//		table
//				.setDescription("Query this table to obtain comments associated with one or more fb:comments/Feed story comment XIDs.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("xid", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("object_id", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("post_id", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("fromid", ParamType.INT, false));
//		table.addColumn(new FQLColumn("time", ParamType.INT, false));
//		table.addColumn(new FQLColumn("text", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("username", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("reply_xid", ParamType.STRING, false));
//		return table;
//	}
//
//	private static FQLTable connectionTable() {
//		FQLTable table = new FQLTable("connection");
//		table.setDescription("");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("source_id", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("target_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("target_type", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("is_following", ParamType.BOOL, false));
//		table.addColumn(new FQLColumn("updated_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("is_deleted", ParamType.BOOL, false));
//		return table;
//	}
//
//	/**
//	 * Photo Table
//	 */
//	private static FQLTable photoTable() {
//		FQLTable table = new FQLTable("photo");
//		table
//				.setDescription("Query this table to return information about a photo.<br/>If you need to get photos associated with a group or event, query the photo_tag table.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("pid", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("aid", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("owner", ParamType.INT, false));
//		table.addColumn(new FQLColumn("src_small", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_small_height", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_small_width", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_big", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_big_height", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_big_width", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_height", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_width", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("link", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("caption", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("created", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("modified", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("object_id", ParamType.INT, false));
//		return table;
//	}
//
//	/**
//	 * Photo Tag Table
//	 */
//	private static FQLTable photoTagTable() {
//		FQLTable table = new FQLTable("photo_tag");
//		table
//				.setDescription("Query this table to return information about a photo tag.<br/>You can also use the photo_tag FQL table to query for photos associated with a group (given its gid) or event (given its eid). See below for sample queries on how to do this.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("pid", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("subject", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("owner", ParamType.INT, false));
//		table.addColumn(new FQLColumn("src_small", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_small_height", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_small_width", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_big", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_big_height", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_big_width", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_height", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_width", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("link", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("caption", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("created", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("modified", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("object_id", ParamType.INT, false));
//		return table;
//	}
//
//	/**
//	 * Photo Tag Table
//	 */
//	private static FQLTable statusTable() {
//		FQLTable table = new FQLTable("status");
//		table.setDescription("Query this table to return one or more of a user's statuses.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("uid", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("status_id", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("time", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("source", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("message", ParamType.STRING, false));
//		return table;
//	}
//
//	/**
//	 * Stream Table
//	 */
//	private static FQLTable streamTable() {
//		FQLTable table = new FQLTable("stream");
//		table.setDescription("Query this table to return posts from a user's stream or the user's profile.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("post_id", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("source_id", ParamType.INT, true));
//		table.addColumn(new FQLColumn("filter_key", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("viewer_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("app_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("updated_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("created_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("attribution", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("actor_id", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("target_id", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("message", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("app_data", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("action_links", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("attachment", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("comments", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("likes", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("privacy", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("type", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("permalink", ParamType.STRING, false));
//		return table;
//	}
//
//	/**
//	 * User Table
//	 */
//	private static FQLTable userTable() {
//		FQLTable table = new FQLTable("user");
//		table
//				.setDescription("Query this table to return detailed information from a user's profile. If you need user information for analytic purposes, query the standard_user_info table instead.");
//		// INDEXABLE
//		table.addColumn(new FQLColumn("uid", ParamType.INT, true));
//		table.addColumn(new FQLColumn("name", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("first_name", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("middle_name", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("last_name", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic_small", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic_big", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic_square", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("affiliations", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("profile_update_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("timezone", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("religion", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("birthday", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("birthday_date", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("sex", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("hometown_location", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("meeting_sex", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("meeting_for", ParamType.ARRAY, false));
//		return table;
//	}
//
//	/**
//	 * Notification Table
//	 */
//	private static FQLTable notificationTable() {
//		FQLTable table = new FQLTable("notification");
//		table
//				.setDescription("Query this table to get the notifications for the current session user, that is, any notification that appears on http://www.facebook.com/notifications.php. You can identify app-to-user notifications because for those notifications, both the sender_id and the recipient_id contain the same user ID.<br/>Facebook deletes notifications older than 7 days, so only notifications less than a week old get returned in a query on this table.<br/>For Facebook applications (like Photos or Wall), the notification is always sent in the user's language and locale that were set at the time the notification was sent.");
//		// INDEXABLE
//		table.addColumn(new FQLColumn("recipient_id", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("notification_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("sender_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("created_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("updated_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("title_html", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("title_text", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("body_html", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("body_text", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("href", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("app_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("is_unread", ParamType.BOOL, false));
//		table.addColumn(new FQLColumn("is_hidden", ParamType.BOOL, false));
//		return table;
//	}
//
//	/**
//	 * Group Table
//	 */
//	private static FQLTable groupTable() {
//		FQLTable table = new FQLTable("group");
//		table
//				.setDescription("Query this table to return information about a group.<br/>If you call fql.query without an auth token or session key when querying this table, you'll only get data about a group that is publicly available. That is, the query only returns a group that the logged-in user can see. If you don't pass the logged-in user's ID, the query only returns open groups.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("gid", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("name", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("nid", ParamType.INT, false));
//		table.addColumn(new FQLColumn("pic_small", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic_big", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("description", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("group_type", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("group_subtype", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("recent_news", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("creator", ParamType.INT, false));
//		table.addColumn(new FQLColumn("update_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("office", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("website", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("venue", ParamType.OBJECT, false));
//		table.addColumn(new FQLColumn("privacy", ParamType.STRING, false));
//		return table;
//	}
//
//	/**
//	 * Like Table
//	 */
//	private static FQLTable likeTable() {
//		FQLTable table = new FQLTable("like");
//		table
//				.setDescription("Query this table to return the user IDs of users who like a given Facebook object (video, note, link, photo, or photo album).");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("object_id", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("user_id", ParamType.INT, false));
//		return table;
//	}
//
//	/**
//	 * Link Table
//	 */
//	private static FQLTable linkTable() {
//		FQLTable table = new FQLTable("link");
//		table.setDescription("Query this table to return the links the current user has posted.");
//		// INDEXABLE
//		table.addColumn(new FQLColumn("link_id", ParamType.INT, true));
//		table.addColumn(new FQLColumn("owner", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("owner_comment", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("created_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("title", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("summary", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("url", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("image_urls", ParamType.ARRAY, false));
//		return table;
//	}
//
//	/**
//	 * Link Stat Table
//	 */
//	private static FQLTable linkStatTable() {
//		FQLTable table = new FQLTable("link_stat");
//		table
//				.setDescription("Query this table to return detailed information from your Facebook Share implementation.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("url", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("normalized_url", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("share_count", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("like_count", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("comment_count", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("total_count", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("click_count", ParamType.STRING, false));
//		return table;
//	}
//
//	/**
//	 * Privacy Table
//	 */
//	private static FQLTable privacyTable() {
//		FQLTable table = new FQLTable("privacy");
//		table.setDescription("Query this table to return a user's privacy setting for a given object_id.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("object_id", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("id", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("value", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("description", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("allow", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("deny", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("owner_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("networks", ParamType.INT, false));
//		table.addColumn(new FQLColumn("friends", ParamType.STRING, false));
//		return table;
//	}
//
//	/**
//	 * Profile Table
//	 */
//	private static FQLTable profileTable() {
//		FQLTable table = new FQLTable("profile");
//		table
//				.setDescription("Query this table to return certain (typically publicly) viewable information from a user's profile or Facebook Page that is displayed in a story. Think of this table as a parent class of the page and user tables.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("id", ParamType.INT, true));
//		table.addColumn(new FQLColumn("username", ParamType.STRING, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("name", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("url", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic_square", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic_small", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("pic_big", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("type", ParamType.STRING, false));
//		return table;
//	}
//
//	/**
//	 * Metrics Table
//	 */
//	private static FQLTable metricsTable() {
//		FQLTable table = new FQLTable("metrics");
//		table
//				.setDescription("Query this table to retrieve metrics about your application. All metrics are identified by a name, and a period over which they've been collected (e.g. one day or seven days).");
//		// INDEXABLE
//		table.addColumn(new FQLColumn("end_time", ParamType.INT, true));
//		table.addColumn(new FQLColumn("period", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("active_users", ParamType.INT, false));
//		table.addColumn(new FQLColumn("api_calls", ParamType.INT, false));
//		table.addColumn(new FQLColumn("unique_api_calls", ParamType.INT, false));
//		table.addColumn(new FQLColumn("canvas_page_views", ParamType.INT, false));
//		table.addColumn(new FQLColumn("unique_canvas_page_views", ParamType.INT, false));
//		table.addColumn(new FQLColumn("canvas_http_request_time_avg", ParamType.INT, false));
//		table.addColumn(new FQLColumn("canvas_fbml_render_time_avg", ParamType.INT, false));
//		table.addColumn(new FQLColumn("unique_adds", ParamType.INT, false));
//		table.addColumn(new FQLColumn("unique_removes", ParamType.INT, false));
//		table.addColumn(new FQLColumn("unique_blocks", ParamType.INT, false));
//		table.addColumn(new FQLColumn("canvas_page_views_http_code_0", ParamType.INT, false));
//		table.addColumn(new FQLColumn("canvas_page_views_http_code_200", ParamType.INT, false));
//		table.addColumn(new FQLColumn("canvas_page_views_http_code_200ND", ParamType.INT, false));
//		table.addColumn(new FQLColumn("canvas_page_views_http_code_404", ParamType.INT, false));
//		return table;
//	}
//
//	/**
//	 * Message Table
//	 */
//	private static FQLTable messageTable() {
//		FQLTable table = new FQLTable("message");
//		table
//				.setDescription("Query this table to return information about messages in a thread. The user needs to grant the calling application the read_mailbox extended permission.");
//		table.requiresPermissions(FacebookPermission.read_mailbox);
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("message_id", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("thread_id", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("author_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("body", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("created_time", ParamType.INT, false));
//		table.addColumn(new FQLColumn("attachment", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("viewer_id", ParamType.INT, false));
//		return table;
//	}
//
//	/**
//	 * Thread Table
//	 */
//	private static FQLTable threadTable() {
//		FQLTable table = new FQLTable("thread");
//		table
//				.setDescription("Query this table to return information about message threads in a user's Inbox. The user needs to grant the calling application the read_mailbox extended permission.");
//		table.requiresPermissions(FacebookPermission.read_mailbox);
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("thread_id", ParamType.INT, true));
//		table.addColumn(new FQLColumn("folder_id", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("subject", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("recipients", ParamType.ARRAY, false));
//		table.addColumn(new FQLColumn("updated_time", ParamType.INT, false));
//		table.addColumn(new FQLColumn("parent_message_id", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("parent_thread_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("message_count", ParamType.INT, false));
//		table.addColumn(new FQLColumn("snippet", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("snippet_author", ParamType.INT, false));
//		table.addColumn(new FQLColumn("object_id", ParamType.INT, false));
//		table.addColumn(new FQLColumn("unread", ParamType.INT, false));
//		table.addColumn(new FQLColumn("viewer_id", ParamType.INT, false));
//		return table;
//	}
//
//	/**
//	 * Video Table
//	 */
//	private static FQLTable videoTable() {
//		FQLTable table = new FQLTable("video");
//		table.setDescription("Query this table to return information about a video.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("vid", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("owner", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("title", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("description", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("thumbnail_link", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("embed_html", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("updated_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("created_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("src", ParamType.STRING, false));
//		table.addColumn(new FQLColumn("src_hq", ParamType.STRING, false));
//		return table;
//	}
//
//	/**
//	 * Video Tag Table
//	 */
//	private static FQLTable videoTagTable() {
//		FQLTable table = new FQLTable("video_tag");
//		table
//				.setDescription("Query this table to return information about a video tag. The video_tag table uses the same visibility constraints as the video itself, so a user can see a video tag if and only if that user can see the video itself.<br/>You can also use the video_tag FQL table to query for videos associated with a group (given its gid) or event (given its eid). See below for sample queries on how to do this.");
//
//		// INDEXABLE
//		table.addColumn(new FQLColumn("vid", ParamType.STRING, true));
//		table.addColumn(new FQLColumn("subject", ParamType.INT, true));
//
//		// NON-INDEXABLE
//		table.addColumn(new FQLColumn("updated_time", ParamType.TIME, false));
//		table.addColumn(new FQLColumn("created_time", ParamType.TIME, false));
//		return table;
//	}
//
//}
