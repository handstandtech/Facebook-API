package com.handstandtech.facebook.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.inject.Singleton;
import com.handstandtech.facebook.shared.model.realtime.FacebookRealtimePost;
import com.handstandtech.restclient.server.util.RESTUtil;

/**
 * Facebook Realtime API Callback
 * 
 * @author Sam Edwards
 */
@Singleton
public class FacebookRealtimeCallbackServlet extends HttpServlet {

	private static Logger log = LoggerFactory
			.getLogger(FacebookRealtimeCallbackServlet.class.getName());

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String hub_mode = request.getParameter("hub.mode");
		String hub_challenge = request.getParameter("hub.challenge");
		String hub_verify_token = request.getParameter("hub.verify.token");

		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		sb.append("GET Called");
		sb.append("<br/>");
		sb.append("hub.mode = " + hub_mode);
		sb.append("<br/>");
		sb.append("hub.challenge = " + hub_challenge);
		sb.append("<br/>");
		sb.append("hub.verify_token = " + hub_verify_token);
		sb.append("</p>");

		// EmailSender.sendHTMLMail("sam@handstandtech.com", "Sam",
		// "Facebook Realtime", sb.toString());

		response.getWriter().write(hub_challenge);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String body = RESTUtil.getRequestPostBody(request);

		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		sb.append("POST Called");
		sb.append("<br/>");
		sb.append("body = " + body);
		sb.append("</p>");

		// EmailSender.sendHTMLMail("sam@handstandtech.com", "Sam",
		// "Facebook Realtime POST Request", sb.toString());

		Gson gson = new Gson();
		FacebookRealtimePost post = gson.fromJson(body,
				FacebookRealtimePost.class);

		// EmailSender.sendHTMLMail("sam@handstandtech.com", "Sam",
		// "Facebook Realtime POST Decode Worked",
		// gson.toJson(post));

	}

}
