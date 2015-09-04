package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    @Test
    public void shouldStartApplicationAndRunDisplayMethodsOnWelcomeAndBookList(){
        WelcomeMessage mockWelcome = mock(WelcomeMessage.class);
        BookList mockBookList = mock(BookList.class);
        Biblioteca biblioteca = new Biblioteca(mockWelcome, mockBookList);

        biblioteca.startApplication();

        verify(mockWelcome).display();
        verify(mockBookList).display();
    }
}
