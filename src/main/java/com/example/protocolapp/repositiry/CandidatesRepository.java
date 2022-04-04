package com.example.protocolapp.repositiry;

import com.example.protocolapp.entity.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesRepository extends JpaRepository<Candidates, Long> {
}
