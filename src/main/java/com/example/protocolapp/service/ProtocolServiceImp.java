package com.example.protocolapp.service;

import com.example.protocolapp.entity.Candidates;
import com.example.protocolapp.entity.Protocol;
import com.example.protocolapp.exception.ProtocolNotFoundException;
import com.example.protocolapp.repositiry.ProtocolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProtocolServiceImp implements ProtocolService{
    private final ProtocolRepository protocolRepository;

    @Override
    public void saveProtocol(Protocol protocol) {
        protocol.getCandidates().forEach(protocol::addCandidates);
        System.out.println();
        protocolRepository.save(protocol);
    }

    @Override
    public Protocol getProtocol(Long id) {
        Protocol protocol = protocolRepository.findById(id).orElseThrow(()-> new ProtocolNotFoundException(id));
        return protocol;
    }
}
