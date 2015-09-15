package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOne(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory);

        assertEquals(ListBooksMenuOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnQuitMenuOptionWhenInputIsTwo(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory);

        assertEquals(QuitMenuOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutMenuOptionWhenInputIsThree(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory);

        assertEquals(CheckoutBookMenuOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnCheckInMenuOptionWhenInputIsFour(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory);

        assertEquals(CheckInBookMenuOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuOptionWhenInputIsInvalid(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory);

        assertEquals(InvalidMenuOption.class, parser.parse("blah").getClass());
    }

    @Test
    public void shouldReturnListMoviesMenuOptionWhenInputIsFive(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Parser parser = new Parser(inputReader, library, movieLibrary,consoleDisplayFactory);

        assertEquals(ListMoviesMenuOption.class, parser.parse("5").getClass());
    }

    @Test
    public void shouldReturnCheckOutMovieMenuOptionWhenInputIsSix(){
        Library library = mock(Library.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputReader inputReader =  mock(InputReader.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Parser parser = new Parser(inputReader, library, movieLibrary,consoleDisplayFactory);

        assertEquals(CheckOutMovieMenuOption.class, parser.parse("6").getClass());
    }
}
