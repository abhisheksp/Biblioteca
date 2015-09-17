package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticatorFactoryTest {

    @Test
    public void shouldReturnDefaultAuthenticatorWhenDefaultAuthenticatorIsCalled(){
        AuthenticatorFactory authenticatorFactory = new AuthenticatorFactory();

        assertEquals(Authenticator.class, authenticatorFactory.getDefaultAuthenticator().getClass());
    }
}
