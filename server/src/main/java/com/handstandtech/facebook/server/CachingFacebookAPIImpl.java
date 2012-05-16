package com.handstandtech.facebook.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.handstandtech.facebook.shared.exception.FacebookException;
import com.handstandtech.facebook.shared.model.FacebookUser;
import com.handstandtech.memcache.CacheKeyMaker;
import com.handstandtech.memcache.MemcacheScopeManager;

public class CachingFacebookAPIImpl extends FacebookAPIImpl {
	private static final String FRIENDS = "friends";

	public CachingFacebookAPIImpl(String token) {
		super(token);
	}

	@Override
	public List<FacebookUser> getUserFriends(String id) throws FacebookException {
		String scope = getScope(FacebookUser.class);
		Map<String, Object> params = new HashMap<String, Object>();
		CacheKeyMaker.addParam(params, String.class, "id", id);
		String key = CacheKeyMaker.createKey(params);
		List<FacebookUser> items = (List<FacebookUser>) MemcacheScopeManager.getFromCache(scope, key);
		if (items == null) {
			items = super.getUserFriends(id);
			MemcacheScopeManager.setClean(scope, key, items);
		}
		return items;
	}

	private String getScope(Class<?> clazz) {
		return clazz.getSimpleName() + "-" + accessToken;
	}

	private String getScope(String s) {
		return s + "-" + accessToken;
	}

}
