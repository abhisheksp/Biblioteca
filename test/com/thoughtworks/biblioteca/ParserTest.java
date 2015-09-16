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

    @Test
    public void shouldReturnCheckOutMovieMenuOptionWhenInputIsThreeAndCurrentUserIsGuest(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckOutMovieMenuOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnLoginMenuOptionWhenInputIsFourAndCurrentUserIsGuest(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(LoginMenuOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnQuitMenuOptionWhenInputIsFiveAndCurrentUserIsGuest(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(QuitMenuOption.class, parser.parse("5").getClass());
    }

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOneAndCurrentUserIsAuthenticatedUser(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListBooksMenuOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnListMoviesMenuOptionWhenInputIsTwoAndCurrentUserIsAuthenticatedUser(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListMoviesMenuOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutBookMenuOptionWhenInputIsThreeAndCurrentUserIsAuthenticatedUser(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckoutBookMenuOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnCheckInBookMenuOptionWhenInputIsFourAndCurrentUserIsAuthenticatedUser(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckInBookMenuOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnCheckoutMovieMenuOptionWhenInputIsFiveAndCurrentUserIsAuthenticatedUser(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckOutMovieMenuOption.class, parser.parse("5").getClass());
    }

    @Test
    public void shouldReturnQuitMenuOptionWhenInputIsSevenAndCurrentUserIsAuthenticatedUser(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(QuitMenuOption.class, parser.parse("7").getClass());
    }
}
