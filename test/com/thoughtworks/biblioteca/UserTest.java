package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    @Test
    public void shouldBeEqualtoItself() {
        User user = new User("123-4567", "password");

        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualToAnotherUserWithSameCredentials(){

        assertEquals(new User("123-4567", "password"), new User("123-4567", "password"));
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithDifferentCredentials(){

        assertNotEquals(new User("123-4567", "password"), new User("222-2222", "meh"));
    }
}
