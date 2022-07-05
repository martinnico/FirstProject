package com.demo.firstproject.exception;

public class TechnologyNotFoundException extends RuntimeException{
    public TechnologyNotFoundException(String message){
        super (message);
    }
}
