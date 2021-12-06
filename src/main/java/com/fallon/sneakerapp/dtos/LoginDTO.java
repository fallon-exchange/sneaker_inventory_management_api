package com.fallon.sneakerapp.dtos;

public class LoginDTO {
    //TODO
    //DTO
    String username;
    String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDTO() {
        super();
    }

    public String getUsername() {
        return username;
    }

}
