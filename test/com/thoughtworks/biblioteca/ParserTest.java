package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOneAndCurrentUserIsGuest(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListBooksMenuOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnListMoviesMenuOptionWhenInputIsTwoAndCurrentUserIsGuest(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListMoviesMenuOption.class, parser.parse("2").getClass());
    }
}
