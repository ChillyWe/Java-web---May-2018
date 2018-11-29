package org.softuni.fdmc.data.models;

import java.sql.Struct;

public class User {
    private String username;

    private String password;

    private boolean isAdmin;

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        this.setAdmin(false);
    }

    public User(String username, String password, boolean isAdmin) {
        this(username, password);
        this.setAdmin(isAdmin);
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

    private void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
