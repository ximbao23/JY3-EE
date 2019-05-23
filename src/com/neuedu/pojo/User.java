package com.neuedu.pojo;

public class User {
    public User(){}

    public User(String username, String psw, Integer id) {
        this.username = username;
        this.psw = psw;
        this.id = id;
    }

    private String username;
    private String psw;
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", psw='" + psw + '\'' +
                ", id=" + id +
                '}';
    }
}
