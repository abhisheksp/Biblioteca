package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserFactoryTest {

    @Test
    public void shouldReturnNewParserWithPassedStatesWhenNewParserIsCalled(){
        Library library = new LibraryFactory().getDefaultLibrary();
        MovieLibrary movieLibrary = new MovieLibraryFactory().getDefaultMovieLibrary();
        User currentUser = new User("", "", "guest");
        ParserFactory parserFactory = new ParserFactory();

        assertEquals(Parser.class, parserFactory.getNewParser(library, movieLibrary, currentUser).getClass());
    }
}
