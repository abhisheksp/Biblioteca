package com.thoughtworks.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    private String role;

    public User(String libraryNumber, String password, String role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        User thatUser = (User) that;
        if (!libraryNumber.equals(thatUser.libraryNumber)) return false;
        return password.equals(thatUser.password);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
