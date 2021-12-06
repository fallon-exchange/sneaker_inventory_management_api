package com.fallon.sneakerapp.exceptions;

public class InvalidUserException extends Exception{
    public InvalidUserException(){
        super("This user is not valid");
    }
}
