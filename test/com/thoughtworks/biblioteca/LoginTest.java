package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginTest {

    @Test
    public void shouldCallReadOnInputTwiceToTakeLoginCredentialsWhenLoginIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Authenticator authenticator = mock(Authenticator.class);
        Session session = mock(Session.class);
        Login login = new Login(authenticator, inputReader, consoleDisplayFactory, session);

        when(inputReader.read()).thenReturn("222-2222", "juliusseizure");
        login.doOperation();

        verify(inputReader, times(2)).read();
    }

    @Test
    public void shouldCallAuthenticateOnAuthenticatorWhenLoginIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Authenticator authenticator = mock(Authenticator.class);
        Session session = mock(Session.class);
        Login login = new Login(authenticator, inputReader, consoleDisplayFactory, session);

        when(inputReader.read()).thenReturn("222-2222", "juliusseizure");
        login.doOperation();

        verify(authenticator).authenticate(anyString(), anyString());
    }

    @Test
    public void shouldReturnCurrentSessionWithUserWhenSessionIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Authenticator authenticator = mock(Authenticator.class);
        Session session =  new SessionFactory().getNewSession(new User("", "", "guest"));
        Login login = new Login(authenticator, inputReader, consoleDisplayFactory, session);

        assertEquals(Session.class, login.session().getClass());
    }
}
