package com.example.content.exceptions;

public class DTMemberNotFoundException extends RuntimeException{

    public DTMemberNotFoundException(String msg){
        super(msg);
    }

    public DTMemberNotFoundException(String msg, Throwable cause){
        super(msg,cause);
    }
}
