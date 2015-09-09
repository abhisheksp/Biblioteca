package com.thoughtworks.biblioteca;

import org.junit.Test;

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

}
