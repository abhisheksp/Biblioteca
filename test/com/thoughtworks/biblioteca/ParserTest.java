package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnListBooksMenuOptionWhenInputIsOne(){
        Library library = mock(Library.class);
        Parser parser = new Parser("1", library);

        assertEquals(ListBooksMenuOption.class, parser.parse().getClass());
    }
}
