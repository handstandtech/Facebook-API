package com.handstandtech.facebook.server;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.handstandtech.facebook.server.util.TimesInMilliseconds;
import com.handstandtech.facebook.shared.exception.FacebookException;
import com.handstandtech.facebook.shared.model.FacebookFeedResponse;
import com.handstandtech.facebook.shared.model.FacebookGraphUser;
import com.handstandtech.facebook.shared.model.FacebookPhoto;
import com.handstandtech.facebook.shared.model.FacebookUser;
import com.handstandtech.facebook.shared.model.places.FacebookGraphCheckins;
import com.handstandtech.restclient.server.RESTClient;
import com.handstandtech.restclient.server.auth.NullAuthenticator;
import com.handstandtech.restclient.server.impl.RESTClientAppEngineURLFetchImpl;
import com.handstandtech.restclient.server.model.RESTRequest;
import com.handstandtech.restclient.server.util.RESTUtil;
import com.handstandtech.restclient.shared.model.RESTResult;
import com.handstandtech.restclient.shared.model.RequestMethod;
import com.handstandtech.restclient.shared.util.RESTURLUtil;

public class FacebookAPIImpl implements FacebookAPI {

	private static String app_id;

	protected static final Logger log = LoggerFactory.getLogger(FacebookAPIImpl.class.getName());
	protected static final String BASE_URL = "https://graph.facebook.com";
	protected String accessToken;

	public FacebookAPIImpl(String accessToken) {
		this.accessToken = accessToken;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handstandtech.facebook.server.FacebookAPI#getUserInfo(java.lang.String
	 * )
	 */
	@Override
	public FacebookGraphUser getUserInfo(String id) throws FacebookException {
		String baseUrl = BASE_URL + "/" + id;
		Map<String, String> params = getParamsWithAccessToken();
		String fullUrl = RESTURLUtil.createFullUrl(baseUrl, params);
		log.info("Full URL: " + fullUrl);

		RESTResult result = getRESTClient().request(RequestMethod.GET, fullUrl);
		log.info("Result..." + result);
		return FacebookUtils.getFacebookGraphUserFromResult(result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handstandtech.facebook.server.FacebookAPI#getUserCheckins(java.lang
	 * .String)
	 */
	@Override
	public FacebookGraphCheckins getUserCheckins(String id) throws FacebookException {
		String baseUrl = BASE_URL + "/" + id + "/checkins";

		Map<String, String> params = getParamsWithAccessToken();

		String fullUrl = RESTURLUtil.createFullUrl(baseUrl, params);

		RESTResult result = getRESTClient().request(RequestMethod.GET, fullUrl);

		Gson gson = new Gson();
		FacebookGraphCheckins facebookGraphCheckins = gson.fromJson(result.getResponseBody(), FacebookGraphCheckins.class);
		return facebookGraphCheckins;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handstandtech.facebook.server.FacebookAPI#getUserFeed(java.lang.String
	 * )
	 */
	@Override
	public FacebookFeedResponse getUserFeed(String id) throws FacebookException {
		String baseUrl = BASE_URL + "/" + id + "/feed";

		Map<String, String> params = getParamsWithAccessToken();
		params.put("limit", "20");

		String fullUrl = RESTURLUtil.createFullUrl(baseUrl, params);

		RESTResult result = getRESTClient().request(RequestMethod.GET, fullUrl);

		log.info("[FEED] " + result.toString());

		return FacebookUtils.getFacebookFeedFromResult(result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handstandtech.facebook.server.FacebookAPI#getUserFriends(java.lang
	 * .String)
	 */
	@Override
	public List<FacebookUser> getUserFriends(String id) throws FacebookException {
		String baseUrl = BASE_URL + "/" + id + "/friends";

		Map<String, String> params = getParamsWithAccessToken();

		String fullUrl = RESTURLUtil.createFullUrl(baseUrl, params);

		RESTResult result = getRESTClient().request(RequestMethod.GET, fullUrl);

		log.info(result.toString());

		return FacebookUtils.getFriendsFromResult(result);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handstandtech.facebook.server.FacebookAPI#getRealtimeAccessToken(
	 * java.lang.String)
	 */
	@Override
	public String getRealtimeAccessToken(String facebookAppId, String facebookAppSecret) throws FacebookException {
		String baseUrl = BASE_URL + "/oauth/access_token";

		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", facebookAppId);
		params.put("client_secret", facebookAppSecret);
		params.put("grant_type", "client_credentials");

		String accessTokenUrl = RESTURLUtil.createFullUrl(baseUrl, params);

		log.info(accessTokenUrl);

		RESTResult restResult = getRESTClient().request(RequestMethod.GET, accessTokenUrl);

		log.info(restResult.toString());

		String vals[] = restResult.getResponseBody().split("=");
		String key = vals[0];
		String value = vals[1];
		String access_token = null;
		if (key.equals("access_token")) {
			access_token = value;
		}
		return access_token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.handstandtech.facebook.server.FacebookAPI#realtimeBaseUrl()
	 */
	@Override
	public String realtimeBaseUrl() throws FacebookException {
		// String app_id = FacebookAPIConstantsServerHelper.getCurrentAppId();
		// String access_token = getRealtimeAccessToken(app_id);
		String postUrl = BASE_URL + "/" + RESTUtil.encode(app_id) + "/subscriptions";
		log.info("Get List of Subscriptions: " + postUrl);

		RESTResult restResult = getRESTClient().request(RequestMethod.GET, postUrl);

		log.info(restResult.toString());

		log.info("Subscriptions: " + restResult.getResponseBody());
		return postUrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handstandtech.facebook.server.FacebookAPI#subscribeToRealtimeUserUpdates
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public void subscribeToRealtimeUserUpdates(String access_token, String app_id) {
		String callbackUrl = "http://www.socialusage.com/facebook/realtime-callback";
		String fields = "feed";// , friends, activities, interests, music,
								// books, movies, television, likes, checkins";
		String location = BASE_URL + "/" + RESTUtil.encode(app_id) + "/subscriptions";

		Map<String, String> params = getParamsWithAccessToken();
		params.put("object", "user");
		params.put("fields", fields);
		params.put("callback_url", callbackUrl);
		params.put("verify_token", "12345");

		String paramString = RESTURLUtil.createParamString(params);

		RESTResult restResult = getRESTClient().requestWithBody(RequestMethod.POST, location, new NullAuthenticator(), paramString.getBytes());

		log.info(restResult.toString());
	}

	private RESTClient getRESTClient() {
		return new RESTClientAppEngineURLFetchImpl();
	}

	@Override
	public List<FacebookPhoto> getRecentPhotosForUser(String uid, Integer limit) {
		if (limit == null) {
			// Default Limit if none is given
			limit = 10;
		}

		Long timeAgo = (new Date().getTime() - TimesInMilliseconds.ONE_WEEK) / 1000;
		String innerSelectStatement = "SELECT aid FROM album WHERE owner= " + uid + " AND modified > " + timeAgo + " ORDER BY modified desc";
		String fqlQuery = "SELECT pid, aid, src_small, src_small_height, src_small_width, owner, caption, created, src_big, src_big_height, src_big_width, src, src_height, src_width, link, object_id FROM photo WHERE aid IN ("
				+ innerSelectStatement + ") ORDER BY created desc LIMIT " + limit;
		log.debug("FQL Query: " + fqlQuery);

		Map<String, String> params = getParamsWithAccessToken();
		params.put("query", RESTUtil.encode(fqlQuery));
		params.put("format", "json");
		String urlString = RESTURLUtil.createFullUrl("https://api.facebook.com/method/fql.query", params);

		RESTResult result = getRESTClient().request(RequestMethod.GET, urlString);

		List<FacebookPhoto> photos = FacebookUtils.getFacebookPhotos(result.getResponseBody());
		return photos;
	}

	private Map<String, String> getParamsWithAccessToken() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", RESTUtil.encode(accessToken));
		return params;
	}

	@Override
	public RESTResult doFql(String fqlQuery) {

		String baseUrl = BASE_URL + "/fql";
		Map<String, String> params = getParamsWithAccessToken();
		params.put("format", "json");

		params.put("q", RESTUtil.encode(fqlQuery));
		String fullUrl = RESTURLUtil.createFullUrl(baseUrl, params);
		log.info("Full URL: " + fullUrl);

		RESTRequest request = new RESTRequest(RequestMethod.GET, fullUrl);

		RESTResult result = getRESTClient().request(request);
		return result;
	}

}
