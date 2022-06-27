package com.demo.firstproject.exception;

public class CandidateNotFound extends RuntimeException{
    public  CandidateNotFound(String message){
        super (message);
    }
}
