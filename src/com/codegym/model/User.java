package com.codegym.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;
    private String phoneNum;
    private String email;

    public User() {
    }

    public User(String userName, String password, String phoneNum, String email) {
        this.userName = userName;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User name:" + userName + ", Parwword: " + password + ", Phone number: " + phoneNum + ", Email: " + email;
    }
}
