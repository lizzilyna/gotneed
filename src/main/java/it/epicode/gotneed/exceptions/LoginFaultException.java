package it.epicode.gotneed.exceptions;

public class LoginFaultException extends RuntimeException{
    public LoginFaultException(String message){
        super(message);
    }
}
