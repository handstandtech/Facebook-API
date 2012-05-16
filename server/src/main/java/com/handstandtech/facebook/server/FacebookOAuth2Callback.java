package com.handstandtech.facebook.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.utils.SystemProperty;

public abstract class FacebookOAuth2Callback extends HttpServlet {

	public static final String ACCESS_TOKEN = "facebook_access_token";
	public static final String EXPIRES = "facebook_access_token_expires";

	/**
	 * Default Serialization UID
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory
			.getLogger(FacebookOAuth2Connect.class.getName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");
		log.info("Code: " + code);

		String hostName = request.getServerName();
		int hostPort = request.getServerPort();
		StringBuilder base = new StringBuilder();
		base.append("http://" + hostName);
		if (hostPort != 80) {
			base.append(":" + hostPort);
		}

		try {
			String app_id = getCurrentAppId(request);
			String fullUrl = "https://graph.facebook.com/oauth/access_token?"
					+ "client_id=" + app_id + "&" + "redirect_uri="
					+ base.toString() + "/facebook/callback&"
					+ "client_secret=" + getCurrentAppSecret(app_id) + "&"
					+ "code=" + URLEncoder.encode(code, "UTF-8");

			// Call to get the OAuth Access Token
			String secondResponse = callUrl(fullUrl);

			String accessToken = null;
			Integer expires = null;
			String[] pairs = secondResponse.split("&");
			for (String pair : pairs) {
				String[] kv = pair.split("=");
				if (kv.length != 2) {
					throw new RuntimeException("Unexpected auth response");
				} else {
					if (kv[0].equals(ACCESS_TOKEN)) {
						accessToken = kv[1];
					}
					if (kv[0].equals(EXPIRES)) {
						expires = Integer.valueOf(kv[1]);
					}
				}
			}

			log.info("Access Token: " + accessToken);
			log.info("Expires : " + expires);
			HttpSession session = request.getSession();
			session.setAttribute(ACCESS_TOKEN, accessToken);
			try {
				if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
					response.sendRedirect("/");
				} else {
					response.sendRedirect("/?gwt.codesvr=127.0.0.1:9997");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	protected abstract String getCurrentAppSecret(String app_id);

	protected abstract String getCurrentAppId(HttpServletRequest request);

	/**
	 * Call the URL with the OAuthConsumer and return the response string.
	 * 
	 * @param consumer
	 * @param endpoint
	 * @return
	 * @throws Exception
	 */
	public static String callUrl(String endpoint) {
		log.info("Calling URL: " + endpoint);

		StringBuffer jsonBuffer = new StringBuffer();
		HttpURLConnection newRequest = null;
		URL url;
		BufferedReader in = null;
		InputStreamReader isr = null;
		try {
			url = new URL(endpoint);
			newRequest = (HttpURLConnection) url.openConnection();
			int ONE_SECOND = 1000;
			newRequest.setConnectTimeout(20 * ONE_SECOND);
			newRequest.setReadTimeout(20 * ONE_SECOND);
			newRequest.connect();
			isr = new InputStreamReader(newRequest.getInputStream(), "UTF-8");
			in = new BufferedReader(isr);
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				log.trace(inputLine);
				jsonBuffer.append(inputLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			newRequest.disconnect();
		}

		return jsonBuffer.toString();
	}
}
