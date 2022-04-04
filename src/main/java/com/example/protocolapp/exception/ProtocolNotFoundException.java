package com.example.protocolapp.exception;

public class ProtocolNotFoundException extends RuntimeException {
    public ProtocolNotFoundException(Long id) {
        super("Protocol not found id = " + id);
    }
}
