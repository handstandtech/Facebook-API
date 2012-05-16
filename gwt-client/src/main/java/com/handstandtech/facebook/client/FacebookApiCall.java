package com.handstandtech.facebook.client;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class FacebookApiCall extends JavaScriptObject {
	
	protected FacebookApiCall() {
		
	}

    public final native void setMethodName(String methodName) /*-{
        this.method = methodName;
    }-*/;

    public final native String getMethodName() /*-{
        return this.method;
    }-*/;
    
    public final void addKeyValue(String key, String value) throws JSONException {
    	JSONObject json = new JSONObject(this);
    	json.put(key, new JSONString(value));
//    	this=json.getJavaScriptObject();
    }
    
    public static final FacebookApiCall create() {
		return (FacebookApiCall) JavaScriptObject.createObject();
    }

}
