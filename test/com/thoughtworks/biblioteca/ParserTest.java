package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOne(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser(inputReader, library);

        assertEquals(ListBooksMenuOption.class, parser.parse("1").getClass());
    }

    @Test
    public void shouldReturnQuitMenuOptionWhenInputIsTwo(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser(inputReader, library);

        assertEquals(QuitMenuOption.class, parser.parse("2").getClass());
    }

    @Test
    public void shouldReturnCheckOutMenuOptionWhenInputIsThree(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser(inputReader, library);

        assertEquals(CheckoutBookMenuOption.class, parser.parse("3").getClass());
    }

    @Test
    public void shouldReturnCheckInMenuOptionWhenInputIsFour(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser(inputReader, library);

        assertEquals(CheckInBookMenuOption.class, parser.parse("4").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuOptionWhenInputIsInvalid(){
        Library library = mock(Library.class);
        InputReader inputReader =  mock(InputReader.class);
        Parser parser = new Parser(inputReader, library);

        assertEquals(InvalidMenuOption.class, parser.parse("blah").getClass());
    }
}
