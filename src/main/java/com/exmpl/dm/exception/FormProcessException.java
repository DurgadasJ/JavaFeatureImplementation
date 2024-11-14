package com.exmpl.dm.exception;

public class FormProcessException extends RuntimeException{

    public FormProcessException(String message, Throwable cause){
        super(message,cause);
    }
    public FormProcessException(String message){
        super(message);
    }
}
