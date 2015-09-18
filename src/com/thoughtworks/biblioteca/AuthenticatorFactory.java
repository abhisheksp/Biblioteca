package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* InputReader factory manufactures a default InputReader and returns it */
public class AuthenticatorFactory {

    private ConsoleDisplayFactory consoleDisplayFactory;

    public AuthenticatorFactory() {
        this.consoleDisplayFactory = new ConsoleDisplayFactory();
    }

    public Authenticator getDefaultAuthenticator() {
        return new Authenticator(getRegisteredUsers(), consoleDisplayFactory);
    }

    private ArrayList<User> getRegisteredUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("666-2222", "blacksheep", "librarian", "Voldemort", "voldemort@killharry.com", "999999999"));
        users.add(new User("222-2222", "juliusseizure", "user", "Julius Caesar", "julius@caesar.com", "888888888"));
        users.add(new User("888-2222", "murica", "user", "Barack Obama", "obama@us.gov", "555555555"));
        return users;
    }
}
