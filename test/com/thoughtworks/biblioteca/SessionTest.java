package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionTest {

    private final String GUEST_USER_LIBRARY_NUMBER = "";
    private final String GUEST_USER_PASSWORD = "";

    @Test
    public void shouldReturnCurrentUserWhenCurrentUserIsCalled() {
        User guestUser = new User(GUEST_USER_LIBRARY_NUMBER, GUEST_USER_PASSWORD, "guest");
        Session session = new Session(guestUser);

        assertEquals(new User(GUEST_USER_LIBRARY_NUMBER, GUEST_USER_PASSWORD, "guest"), session.currentUser());
    }
}
