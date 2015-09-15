package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {

    @Test
    public void shouldReturnUserInstanceIfCredentialsMatchesAValidUser(){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("222-2222", "juliusseizure", "user"));
        users.add(new User("444-2222", "randomstuff", "user"));
        users.add(new User("888-2222", "morerandomstuff", "user"));
        Authenticator authenticator = new Authenticator(users);

        assertEquals(new User("222-2222", "juliusseizure", "user"), authenticator.authenticate("222-2222", "juliusseizure"));
    }

    @Test
    public void shouldReturnDefaultGuestUserInstanceIfCredentialsDoesNotMatchAnyUser(){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("222-2222", "juliusseizure", "user"));
        users.add(new User("444-2222", "randomstuff", "user"));
        users.add(new User("888-2222", "morerandomstuff", "user"));
        Authenticator authenticator = new Authenticator(users);

        assertEquals(new User("000-0000", "blacksheep", "user"), authenticator.authenticate("123-4567", "notavalidpassword"));
    }
}
