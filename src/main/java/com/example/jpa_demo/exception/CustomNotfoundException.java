package com.example.jpa_demo.exception;

public class CustomNotfoundException extends  RuntimeException{
    public CustomNotfoundException(String message){
        super(message);
    }
}
