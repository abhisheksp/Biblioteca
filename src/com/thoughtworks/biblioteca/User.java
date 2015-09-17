package com.thoughtworks.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    private String role;
    private String name;
    private String emailId;
    private String phoneNumber;

    public User(String libraryNumber, String password, String role, String name, String emailId, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String format(){
        return String.format("%-20s%-20s%-30s%-20s\n", this.libraryNumber, this.name, this.emailId, this.phoneNumber);
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

    public String role() {
        return this.role;
    }
}
