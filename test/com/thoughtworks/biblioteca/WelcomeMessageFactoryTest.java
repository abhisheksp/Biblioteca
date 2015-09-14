package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageFactoryTest {

    @Test
    public void shouldReturnDefaultWelcomeMessage() {
        WelcomeMessageFactory welcomeMessageFactory = new WelcomeMessageFactory();

        assertEquals(WelcomeMessage.class, welcomeMessageFactory.getDefaultWelcomeMessage().getClass());
    }
}
