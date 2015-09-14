package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ControllerTest {

    @Test
    public void shouldCallFormatOnWelcomeMessageWhenStartIsCalled() {
        WelcomeMessage welcomeMessage = mock(WelcomeMessage.class);
        MainMenu mainMenu = mock(MainMenu.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        Controller controller = new Controller(welcomeMessage, mainMenu, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(consoleDisplay);
        controller.start();

        verify(welcomeMessage).format();
    }

    @Test
    public void shouldCallInteractWithUserOnMainMenuWhenStartIsCalled() {
        WelcomeMessage welcomeMessage = mock(WelcomeMessage.class);
        MainMenu mainMenu = mock(MainMenu.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        Controller controller = new Controller(welcomeMessage, mainMenu, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(consoleDisplay);
        controller.start();

        verify(mainMenu).interactWithUser();
    }
}
