package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    @Test
    public void shouldBeEqualtoItself() {
        User user = new User("123-4567", "password", "user");

        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualToAnotherUserWithSameCredentials(){

        assertEquals(new User("123-4567", "password", "user"), new User("123-4567", "password", "user"));
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithDifferentCredentials(){

        assertNotEquals(new User("123-4567", "password", "user"), new User("222-2222", "meh", "user"));
    }

    @Test
    public void shouldNotBeEqualToNull(){

        assertNotEquals(new User("123-4567", "password", "user"), null);
    }

    @Test
    public void shouldNotBeEqualToNonUserEntity(){

        assertNotEquals(new User("123-4567", "password", "user"), "Definitely not a User");
    }

    @Test
    public void shouldHaveSameHashCodeAsAnotherUserWithSameCredentials(){

        assertEquals(new User("123-4567", "password", "user").hashCode(), new User("123-4567", "password", "user").hashCode());
    }
}
