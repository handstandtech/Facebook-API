package com.handstandtech.facebook.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface FacebookLoggedOutEventHandler extends EventHandler {
    void onLogout(FacebookLoggedOutEvent event);
}
