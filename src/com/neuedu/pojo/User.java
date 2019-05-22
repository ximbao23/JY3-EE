package com.neuedu.pojo;

public class User {
    public User(){}

    public User(String username, String psw) {
        this.username = username;
        this.psw = psw;
    }

    private String username;
    private String psw;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
