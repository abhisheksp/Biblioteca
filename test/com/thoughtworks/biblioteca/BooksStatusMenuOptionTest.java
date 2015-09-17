package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BooksStatusMenuOptionTest {

    @Test
    public void shouldCallLibraryCheckOutInformationWhenDoOperationIsCalled() {
        Library library = mock(Library.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        BooksStatusMenuOption booksStatusMenuOption = new BooksStatusMenuOption(library, consoleDisplayFactory);

        when(library.bookCheckOutInformation()).thenReturn("doesn't matter");
        booksStatusMenuOption.doOperation();

        verify(library).bookCheckOutInformation();
    }
}
