package org.softuni.fdmc.data.models;

public class User {
    private String username;

    private String password;

    private boolean isAdmin;

    public User(String username, String password, boolean amI) {
        this.setUsername(username);
        this.setPassword(password);
        this.setAdmin(amI);
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}