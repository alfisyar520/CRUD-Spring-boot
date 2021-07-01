package com.domain.crudapi.exceptions;

public class Excep extends RuntimeException{

    public Excep(String message) {
        super (message);
    }

    public Excep(String message, Object data) {
        super (message);
    }

    public Excep(String message, Throwable cause){
        super (message, cause);
    }

}
