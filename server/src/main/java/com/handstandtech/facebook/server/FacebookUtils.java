package com.handstandtech.facebook.server;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.handstandtech.facebook.shared.model.FacebookFeedItem;
import com.handstandtech.facebook.shared.model.FacebookFeedResponse;
import com.handstandtech.facebook.shared.model.FacebookGraphUser;
import com.handstandtech.facebook.shared.model.FacebookPhoto;
import com.handstandtech.facebook.shared.model.FacebookUser;
import com.handstandtech.restclient.shared.model.RESTResult;

public class FacebookUtils {

	// 2010-10-18T01:17:39+0000
	private static final String FACEBOOK_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";

	private static Logger log = LoggerFactory.getLogger(FacebookUtils.class);

	public static FacebookGraphUser getFacebookGraphUserFromResult(
			RESTResult result) {

		Gson gson = getFacebookGson();
		FacebookGraphUser facebookGraphUser = gson.fromJson(
				result.getResponseBody(), FacebookGraphUser.class);
		return facebookGraphUser;
	}

	private static Gson getFacebookGson() {
		Gson gson = new Gson();
		gson = new GsonBuilder().registerTypeAdapter(Date.class,
				new JsonDeserializer<Date>() {
					public Date deserialize(JsonElement arg0, Type arg1,
							JsonDeserializationContext arg2)
							throws JsonParseException {
						String date = arg0.getAsString();
						date = date.replaceAll("T", " ");

						SimpleDateFormat df = new SimpleDateFormat(
								FACEBOOK_DATE_FORMAT);
						try {
							return df.parse(date);
						} catch (ParseException e) {
							throw new JsonParseException("Cannot parse date: "
									+ e.getMessage(), e);
						}
					}

				}).create();
		return gson;
	}

	public static FacebookFeedResponse getFacebookFeedFromResult(
			RESTResult result) {
		FacebookFeedResponse facebookFeedResponse = null;
		try {
			facebookFeedResponse = getFacebookGson().fromJson(
					result.getResponseBody(), FacebookFeedResponse.class);
			if (facebookFeedResponse != null) {
				List<FacebookFeedItem> data = facebookFeedResponse.getData();
				log.debug("Data: " + data);
				if (data != null) {
					log.debug("Data Size: " + data.size());
				} else {
					log.error("Data was null");
				}
			} else {
				log.error("WAS NULL");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error Occurred when Gsoning Facebook Feed Response", e);
		}
		return facebookFeedResponse;
	}

	public static List<FacebookUser> getFriendsFromResult(RESTResult result) {
		List<FacebookUser> friends = new LinkedList<FacebookUser>();

		String json = result.getResponseBody();

		Gson gson = getFacebookGson();
		JSONObject obj;
		JSONArray jsonFriends;
		try {
			obj = new JSONObject(json);

			jsonFriends = obj.getJSONArray("data");
			for (int i = 0; i < jsonFriends.length(); i++) {
				JSONObject jsonFriend = jsonFriends.getJSONObject(i);
				FacebookUser facebookObject = gson.fromJson(
						jsonFriend.toString(), FacebookUser.class);
				friends.add(facebookObject);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return friends;
	}

	public static List<FacebookPhoto> getFacebookPhotos(String responseBody) {
		List<FacebookPhoto> photos = new ArrayList<FacebookPhoto>();
		try {
			JSONArray array = new JSONArray(responseBody);
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				String caption = obj.getString("caption");
				Double created = obj.getDouble("created");
				String object_id = obj.getString("object_id");
				String pid = obj.getString("pid");
				String aid = obj.getString("aid");
				Date createdDate = new Date((long) (created * 1000));
				String src = obj.getString("src");
				String srcBig = obj.getString("src_big");
				String permalink = obj.getString("link");
				String owner = obj.getString("owner");
				System.out.println(aid + " - " + pid + " - " + owner + " - "
						+ createdDate + " - " + caption + " - " + src);

				FacebookPhoto photo = new FacebookPhoto();
				photo.setAid(aid);
				photo.setCaption(caption);
				photo.setCreated(createdDate);
				photo.setId(object_id);
				photo.setPid(pid);
				photo.setOwnerId(owner);
				photo.setSrc(src);
				photo.setSrcBig(srcBig);
				photo.setPermalink(permalink);
				photos.add(photo);
			}
		} catch (JSONException e) {
			//e.printStackTrace();
		}
		return photos;
	}

}
