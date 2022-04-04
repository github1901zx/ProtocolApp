package com.example.protocolapp.repositiry;

import com.example.protocolapp.entity.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
}
