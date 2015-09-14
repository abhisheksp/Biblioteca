package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckInBookMenuOptionTest {

    @Test
    public void shouldCallInputReaderReadWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, library);

        checkInBookMenuOption.doOperation();

        verify(inputReader).read();
    }

    @Test
    public void shouldCallLibraryCheckoutWithGivenBookWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, library);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        checkInBookMenuOption.doOperation();

        verify(library).checkIn(argumentCaptor.capture());
    }
}