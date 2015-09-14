package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @Test
    public void shouldCallDisplayOnWelcomeMessageWhenStartIsCalled() {
        WelcomeMessage welcomeMessage = mock(WelcomeMessage.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Controller controller = new Controller(welcomeMessage, mainMenu);

        controller.start();

        verify(welcomeMessage).display();
    }

    @Test
    public void shouldCallInteractWithUserOnMainMenuWhenStartIsCalled() {
        WelcomeMessage welcomeMessage = mock(WelcomeMessage.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Controller controller = new Controller(welcomeMessage, mainMenu);

        controller.start();

        verify(mainMenu).interactWithUser();
    }
}
