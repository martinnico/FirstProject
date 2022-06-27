package com.demo.firstproject.exception;

public class TechnologyNotFound extends RuntimeException{
    public  TechnologyNotFound(String message){
        super (message);
    }
}
