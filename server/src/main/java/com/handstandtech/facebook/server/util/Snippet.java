package com.handstandtech.facebook.server.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public class Snippet {
	public static String getParameterString(Map<String, String> parameters) {
			StringBuilder sb = new StringBuilder();
			int i = 0;
			Set<String> keys = parameters.keySet();
			for (String key : keys) {
				String value = parameters.get(key);
	
				try {
					value = URLEncoder.encode(value, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				sb.append(key + "=" + value);
				if (i < keys.size() - 1) {
					sb.append("&");
				}
				i++;
			}
			return sb.toString();
		}
}

