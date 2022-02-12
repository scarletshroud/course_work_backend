package com.scarletshroud.course_work.dto;

public class UserRegisterCredentials {

    private String email;
    private String username;
    private String password;

    public UserRegisterCredentials() {
    }

    public UserRegisterCredentials(String email, String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setLogin(String login) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
