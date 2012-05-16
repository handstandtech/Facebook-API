package com.handstandtech.facebook.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.handstandtech.facebook.shared.FacebookConstants;
import com.handstandtech.restclient.server.util.RESTUtil;
import com.handstandtech.restclient.shared.util.RESTURLUtil;

public abstract class FacebookOAuth2Connect extends HttpServlet {
	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory
			.getLogger(FacebookOAuth2Connect.class.getName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String clientId = getCurrentAppId(request);
		String redirectUri = request
				.getParameter(FacebookConstants.REDIRECT_URI);
		String uri = request.getRequestURI();
		String url = request.getRequestURL().toString();
		log.info("URI " + uri);
		log.info("URL " + url);

		int idx = url.lastIndexOf(uri);
		String base = url.substring(0, idx);

		redirectUri = base + redirectUri;

		// Currently null, could be set to access photos, checkins, etc
		String scope = null;

		String loginUrl = buildConnectUrl(clientId, redirectUri, scope);
		log.info("Redirecting for Facebook Login: " + loginUrl);
		try {
			response.sendRedirect(loginUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected abstract String getCurrentAppId(HttpServletRequest request);

	public static String buildConnectUrl(String clientId, String redirectUri,
			String scope) {

		String url = "https://graph.facebook.com/oauth/authorize";
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", clientId);
		params.put("redirect_uri", RESTUtil.encode(redirectUri));
		if (scope != null) {
			params.put("scope", scope);
		}

		return RESTURLUtil.createFullUrl(url, params);
	}
}
