package com.java.projectwork.omnidex_backend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus 
public class RelicNotFoundException extends RuntimeException {
    public RelicNotFoundException(String message){
        super(message);
    }
}
