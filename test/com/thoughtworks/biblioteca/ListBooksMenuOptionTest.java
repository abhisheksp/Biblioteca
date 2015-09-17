package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListBooksMenuOptionTest {

    @Test
    public void shouldCallLibraryDisplayWhenDoOperationIsCalled(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(bookLibrary, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("blah"));
        listBooksMenuOption.doOperation();

        verify(bookLibrary).format();
    }

    @Test
    public void shouldCallConsoleDisplayOnReturnedStringWhenDoOperationIsCalled(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(bookLibrary, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("blah"));
        listBooksMenuOption.doOperation();

        verify(consoleDisplayFactory).getNewConsoleDisplay(anyString());
    }
}
