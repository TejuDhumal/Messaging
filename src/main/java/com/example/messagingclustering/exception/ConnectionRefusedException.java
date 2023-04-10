package com.example.messagingclustering.exception;


public class ConnectionRefusedException extends RuntimeException {

    public ConnectionRefusedException(String msg){
        super(msg);
    }
}
