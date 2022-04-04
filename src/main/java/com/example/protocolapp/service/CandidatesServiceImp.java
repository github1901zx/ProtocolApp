package com.example.protocolapp.service;


import com.example.protocolapp.entity.Candidates;
import com.example.protocolapp.repositiry.CandidatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CandidatesServiceImp implements CandidatesService{
    private final CandidatesRepository candidatesRepository;

    @Override
    public void saveCandidates(Candidates candidates) {
        candidatesRepository.save(candidates);
    }
}
