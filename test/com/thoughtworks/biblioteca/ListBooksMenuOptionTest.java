package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksMenuOptionTest {

    @Test
    public void shouldCallLibraryDisplayWhenDoOperationIsCalled(){
        Library library = mock(Library.class);
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(library);

        listBooksMenuOption.doOperation();

        verify(library).format();
    }
}
