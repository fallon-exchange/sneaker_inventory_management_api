package com.fallon.sneakerapp.pojos;

import com.fallon.sneakerapp.dtos.RegisterDTO;

public class User {
    private int userId;
    private String username;
    private String password;

    public User(){

    }

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(RegisterDTO registerDTO) {
        this.username = registerDTO.getUsername();
        this.password = registerDTO.getPassword();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
