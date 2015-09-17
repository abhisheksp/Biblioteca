package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogoutMenuOptionSpec {

    @Test
    public void shouldSetCurrentUserToGuestWhenDoOperationIsCalled(){
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption();

        logoutMenuOption.doOperation();

        assertEquals("guest", logoutMenuOption.currentUser().role());
    }

    @Test
    public void shouldGetCurrentUserWhenCurrentUserIsCalled(){
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption();

        logoutMenuOption.doOperation();

        assertEquals(new User("", "", "guest", "", "", ""), logoutMenuOption.currentUser());
    }
}
