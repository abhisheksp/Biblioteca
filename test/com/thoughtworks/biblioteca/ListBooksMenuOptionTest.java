package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksMenuOptionTest {

    @Test
    public void shouldCallInputReadWhenDoOperationIsCalled(){
        Library library = mock(Library.class);
        InputReader inputReader = mock(InputReader.class);
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(library, inputReader);

        listBooksMenuOption.doOperation();

        verify(inputReader).read();
    }
}
