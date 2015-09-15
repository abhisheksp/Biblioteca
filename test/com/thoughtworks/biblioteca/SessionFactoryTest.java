package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SessionFactoryTest {

    @Test
    public void shouldReturnNewSessionWithPassedUserAsState() {
        SessionFactory sessionFactory = new SessionFactory();
        User user = mock(User.class);

        assertEquals(Session.class, sessionFactory.getNewSession(user).getClass());
    }
}
