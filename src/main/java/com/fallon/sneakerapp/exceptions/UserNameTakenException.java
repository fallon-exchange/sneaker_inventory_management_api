package com.fallon.sneakerapp.exceptions;

public class UserNameTakenException extends Exception{

    public UserNameTakenException(){
        super("Username is taken.");
    }
}
