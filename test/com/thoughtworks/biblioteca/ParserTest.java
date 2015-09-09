package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOne(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser("1", inputReader, library);

        assertEquals(ListBooksMenuOption.class, parser.parse().getClass());
    }

    @Test
    public void shouldReturnQuitMenuOptionWhenInputIsTwo(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser("2", inputReader, library);

        assertEquals(QuitMenuOption.class, parser.parse().getClass());
    }

    @Test
    public void shouldReturnCheckOutMenuOptionWhenInputIsThree(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser("3", inputReader, library);

        assertEquals(CheckoutBookMenuOption.class, parser.parse().getClass());
    }

    @Test
    public void shouldReturnCheckInMenuOptionWhenInputIsFour(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser("4", inputReader, library);

        assertEquals(CheckInBookMenuOption.class, parser.parse().getClass());
    }

    @Test
    public void shouldReturnInvalidMenuOptionWhenInputIsInvalid(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser("blah", inputReader, library);

        assertEquals(InvalidMenuOption.class, parser.parse().getClass());
    }
}
