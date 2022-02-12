package com.scarletshroud.course_work.util;

import java.util.HashMap;

public class SessionService {
    public final static SessionService sessionService = new SessionService();
    private final HashMap<String, Long> activeSessions = new HashMap<>();

    private SessionService() {
    }

    public void add(String token, Long userId) {
        activeSessions.put(token, userId);
    }

    public Long get(String token) {
        return activeSessions.get(token);
    }

    public void remove(String token) {
        activeSessions.remove(token);
    }

    public boolean contains(String token) {
        return activeSessions.containsKey(token);
    }
}
