package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOneAndCurrentUserIsGuest(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListBooksMenuOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnListMoviesMenuOptionWhenInputIsTwoAndCurrentUserIsGuest(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListMoviesMenuOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutMovieMenuOptionWhenInputIsThreeAndCurrentUserIsGuest(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckOutMovieMenuOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnLoginMenuOptionWhenInputIsFourAndCurrentUserIsGuest(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(LoginMenuOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnQuitMenuOptionWhenInputIsFiveAndCurrentUserIsGuest(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("", "", "guest", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(QuitMenuOption.class, parser.parse("5").getClass());
    }

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOneAndCurrentUserIsAuthenticatedUser(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListBooksMenuOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnListMoviesMenuOptionWhenInputIsTwoAndCurrentUserIsAuthenticatedUser(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListMoviesMenuOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutBookMenuOptionWhenInputIsThreeAndCurrentUserIsAuthenticatedUser(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckOutBookMenuOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnCheckInBookMenuOptionWhenInputIsFourAndCurrentUserIsAuthenticatedUser(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckInBookMenuOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnCheckoutMovieMenuOptionWhenInputIsFiveAndCurrentUserIsAuthenticatedUser(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckOutMovieMenuOption.class, parser.parse("5").getClass());
    }

    @Test
    public void shouldReturnQuitMenuOptionWhenInputIsEightAndCurrentUserIsAuthenticatedUser(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(QuitMenuOption.class, parser.parse("8").getClass());
    }

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOneAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListBooksMenuOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnListMoviesMenuOptionWhenInputIsTwoAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(ListMoviesMenuOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutBookMenuOptionWhenInputIsThreeAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckOutBookMenuOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnCheckInBookMenuOptionWhenInputIsFourAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckInBookMenuOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnCheckOutMovieMenuOptionWhenInputIsFiveAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(CheckOutMovieMenuOption.class, parser.parse("5").getClass());
    }

    @Test
    public void shouldReturnQuitMenuOptionWhenInputIsNineAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(QuitMenuOption.class, parser.parse("9").getClass());
    }

    @Test
    public void shouldReturnLogoutMenuOptionWhenInputIsEightAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(LogoutMenuOption.class, parser.parse("8").getClass());
    }

    @Test
    public void shouldReturnLogoutMenuOptionWhenInputIsSevenAndCurrentUserIsAuthenticatedUser(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(LogoutMenuOption.class, parser.parse("7").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuOptionWhenInputIsInvalid(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(InvalidMenuOption.class, parser.parse("*").getClass());
    }

    @Test
    public void shouldReturnBooksStatusMenuOptionWhenInputIsSixAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(BooksStatusMenuOption.class, parser.parse("6").getClass());
    }

    @Test
    public void shouldReturnUserInformationMenuOptionWhenInputIsSevenAndCurrentUserIsLibrarian(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "librarian", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(UserInformationMenuOption.class, parser.parse("7").getClass());
    }

    @Test
    public void shouldReturnUserInformationMenuOptionWhenInputIsSixAndCurrentUserIsAuthenticatedUser(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        User currentUser = new User("222-2222", "juliusseizure", "user", "", "", "");
        Authenticator authenticator = mock(Authenticator.class);
        Parser parser = new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);

        assertEquals(UserInformationMenuOption.class, parser.parse("6").getClass());
    }
}
