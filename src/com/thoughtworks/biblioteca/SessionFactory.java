package com.thoughtworks.biblioteca;

/* Session factory manufactures a new Session with the given user as state */
public class SessionFactory {

    private Session session;

    public Session getNewSession(User user) {
        session = new Session(user);
        return session;
    }
}
