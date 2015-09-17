package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    @Test
    public void shouldBeEqualtoItself() {
        User user = new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999");

        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualToAnotherUserWithSameCredentials() {

        assertEquals(new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999"), new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999"));
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithDifferentCredentials() {

        assertNotEquals(new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999"), new User("777-6666", "password", "user", "Harry Potter", "harry@saveme.com", "999999999"));
    }

    @Test
    public void shouldNotBeEqualToNull() {

        assertNotEquals(new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999"), null);
    }

    @Test
    public void shouldNotBeEqualToNonUserEntity() {

        assertNotEquals(new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999"), "Definitely not a User");
    }

    @Test
    public void shouldHaveSameHashCodeAsAnotherUserWithSameCredentials() {

        assertEquals(new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999").hashCode(), new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999").hashCode());
    }

    @Test
    public void shouldReturnRoleWhenRoleIsCalled() {
        User user = new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999");

        assertEquals("librarian", user.role());
    }

    @Test
    public void shouldReturnFormattedUserContactInformationWhenFormatIsCalled() {
        User user = new User("666-6666", "password", "librarian", "Voldemort", "voldemort@killharry.com", "999999999");

        assertEquals("666-6666            Voldemort           voldemort@killharry.com999999999           \n", user.format());
    }
}
