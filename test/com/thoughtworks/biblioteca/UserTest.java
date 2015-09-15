package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldBeEqualtoItself() {
        User user = new User("123-4567", "password");

        assertEquals(user, user);
    }
}
