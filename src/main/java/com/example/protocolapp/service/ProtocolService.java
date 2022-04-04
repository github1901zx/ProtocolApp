package com.example.protocolapp.service;

import com.example.protocolapp.entity.Protocol;

public interface ProtocolService {
    void saveProtocol(Protocol protocol);
    Protocol getProtocol(Long id);
}
