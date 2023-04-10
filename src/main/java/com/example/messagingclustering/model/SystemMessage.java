package com.example.messagingclustering.model;

import java.io.Serializable;

public class SystemMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    public String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                ", message='" + message + '\'' +
                '}';
    }
}
