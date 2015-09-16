package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginMenuOptionTest {

    @Test
    public void shouldCallReadOnInputTwiceToTakeLoginCredentialsWhenLoginIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Authenticator authenticator = mock(Authenticator.class);
        User user = mock(User.class);
        LoginMenuOption loginMenuOption = new LoginMenuOption(authenticator, inputReader, consoleDisplayFactory, user);

        when(inputReader.read()).thenReturn("222-2222", "juliusseizure");
        loginMenuOption.doOperation();

        verify(inputReader, times(2)).read();
    }

    @Test
    public void shouldCallAuthenticateOnAuthenticatorWhenLoginIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Authenticator authenticator = mock(Authenticator.class);
        User user = mock(User.class);
        LoginMenuOption loginMenuOption = new LoginMenuOption(authenticator, inputReader, consoleDisplayFactory, user);

        when(inputReader.read()).thenReturn("222-2222", "juliusseizure");
        loginMenuOption.doOperation();

        verify(authenticator).authenticate(anyString(), anyString());
    }

    @Test
    public void shouldReturnCurrentUserWhenCurrentUserIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Authenticator authenticator = mock(Authenticator.class);
        User user = new User("", "", "guest");
        LoginMenuOption loginMenuOption = new LoginMenuOption(authenticator, inputReader, consoleDisplayFactory, user);

        loginMenuOption.currentUser();

        assertEquals(User.class, loginMenuOption.currentUser().getClass());
    }
}
