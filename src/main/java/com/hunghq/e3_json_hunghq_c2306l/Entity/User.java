package com.hunghq.e3_json_hunghq_c2306l.Entity;

public class User {
    public int id;
    public String username;
    public String password;
    public String tokenKey;

    public User() {
        ;
    }

    public User(int id, String username, String password, String tokenKey) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tokenKey = tokenKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }
}
