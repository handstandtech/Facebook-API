package com.handstandtech.facebook.shared.model;

public enum FacebookPermission {
	// User Permissions
	email, read_insights, read_stream, read_mailbox, user_about_me, user_activities, user_birthday, user_education_history, user_events, user_groups, user_hometown, user_interests, user_likes, user_location, user_notes, user_online_presence, user_photo_video_tags, user_photos, user_relationships, user_religion_politics, user_status, user_videos, user_website, user_work_history, read_friendlists, read_requests,

	// Friend Permissions
	friends_about_me, friends_activities, friends_birthday, friends_education_history, friends_events, friends_groups, friends_hometown, friends_interests, friends_likes, friends_location, friends_notes, friends_online_presence, friends_photo_video_tags, friends_photos, friends_relationships, friends_religion_politics, friends_status, friends_videos, friends_website, friends_work_history,

	// Publishing Permissions
	publish_stream, create_event, rsvp_event, sms, offline_access,
	
	// Manage Pages
	manage_pages
}