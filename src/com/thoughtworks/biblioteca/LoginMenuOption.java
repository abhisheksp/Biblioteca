package com.thoughtworks.biblioteca;

/* LoginMenuOption has authenticator, input reader, console display via which it prompts and authenticates user */
public class LoginMenuOption implements MenuOption {

    private Authenticator authenticator;
    private InputReader inputReader;
    private ConsoleDisplayFactory consoleDisplayFactory;
    private Session session;

    public LoginMenuOption(Authenticator authenticator, InputReader inputReader, ConsoleDisplayFactory consoleDisplayFactory, Session session) {
        this.authenticator = authenticator;
        this.inputReader = inputReader;
        this.consoleDisplayFactory = consoleDisplayFactory;
        this.session = session;
    }

    @Override
    public void doOperation() {
        consoleDisplayFactory.getNewConsoleDisplay("Library Number :").display();
        String libraryNumber = inputReader.read();
        consoleDisplayFactory.getNewConsoleDisplay("Password :").display();
        String password = inputReader.read();
        User user = authenticator.authenticate(libraryNumber, password);
        session = new SessionFactory().getNewSession(user);
    }

    public Session session() {
        return session;
    }
}
