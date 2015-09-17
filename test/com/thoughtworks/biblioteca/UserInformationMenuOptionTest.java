package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserInformationMenuOptionTest {

    @Test
    public void shouldCallUserFormatWhenDoOperationIsCalled() {
        User user = mock(User.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        UserInformationMenuOption userInformationMenuOption = new UserInformationMenuOption(consoleDisplayFactory, user);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("blah"));
        when(user.format()).thenReturn("doesn't matter");
        userInformationMenuOption.doOperation();

        verify(user).format();
    }
}
