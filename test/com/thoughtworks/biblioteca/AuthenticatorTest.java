package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {

    @Test
    public void shouldReturnUserInstanceIfCredentialsMatchesAValidUser(){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("222-2222", "juliusseizure"));
        users.add(new User("444-2222", "randomstuff"));
        users.add(new User("888-2222", "morerandomstuff"));
        Authenticator authenticator = new Authenticator(users);

        assertEquals(authenticator.authenticate("222-2222", "juliusseizure"), new User("222-2222", "juliusseizure"));
    }
}
