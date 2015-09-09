package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitMenuOptionTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldSysExitWhenQuitOptionIsChosen(){
        exit.expectSystemExit();

        QuitMenuOption quitMenuOption = new QuitMenuOption();

        quitMenuOption.doOperation();
    }
}
