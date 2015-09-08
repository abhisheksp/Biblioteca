package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookMenuOptionTest {

    @Test
    public void shouldCallInputReaderReadWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader, library);

        checkoutBookMenuOption.doOperation();

        verify(inputReader).read();
    }
}
