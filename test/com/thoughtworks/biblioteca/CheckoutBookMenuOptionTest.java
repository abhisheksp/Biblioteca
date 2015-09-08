package com.thoughtworks.biblioteca;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

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

    @Test
    public void shouldCallLibraryCheckoutWithGivenBookWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader, library);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        checkoutBookMenuOption.doOperation();

        verify(library).checkOutBook(argumentCaptor.capture());
    }
}
