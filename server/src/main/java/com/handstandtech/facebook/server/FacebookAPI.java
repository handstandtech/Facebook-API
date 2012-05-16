package com.handstandtech.facebook.server;

import java.util.List;

import com.handstandtech.facebook.shared.exception.FacebookException;
import com.handstandtech.facebook.shared.model.FacebookFeedResponse;
import com.handstandtech.facebook.shared.model.FacebookGraphUser;
import com.handstandtech.facebook.shared.model.FacebookPhoto;
import com.handstandtech.facebook.shared.model.FacebookUser;
import com.handstandtech.facebook.shared.model.places.FacebookGraphCheckins;
import com.handstandtech.restclient.shared.model.RESTResult;

public interface FacebookAPI {

	public abstract FacebookGraphUser getUserInfo(String id) throws FacebookException;

	public abstract FacebookGraphCheckins getUserCheckins(String id) throws FacebookException;

	public abstract FacebookFeedResponse getUserFeed(String id) throws FacebookException;

	public abstract List<FacebookUser> getUserFriends(String id) throws FacebookException;

	public abstract String getRealtimeAccessToken(String appId, String facebookAppSecret) throws FacebookException;

	public abstract String realtimeBaseUrl() throws FacebookException;

	public abstract void subscribeToRealtimeUserUpdates(String access_token, String app_id);

	public abstract List<FacebookPhoto> getRecentPhotosForUser(String uid, Integer limit);

	public abstract RESTResult doFql(String fqlQuery);

}