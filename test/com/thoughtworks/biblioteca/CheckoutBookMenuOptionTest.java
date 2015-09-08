package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookMenuOptionTest {

    @Test
    public void shouldCallInputReaderReadWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader);

        checkoutBookMenuOption.doOperation();

        verify(inputReader).read();
    }
}
