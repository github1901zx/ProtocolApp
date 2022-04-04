package com.example.protocolapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Candidates")
@Data
public class Candidates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidates_id")
    private Long id;
    @Column(name = "candidates_name")
    private String name;
    @Column(name = "candidates_surName")
    private String surName;
    @Column(name = "candidates_lastName")
    private String lastName;
    @Column(name = "candidates_numberOfVotes")
    private Long numberOfVotes;
    @Column(name = "candidates_percentageOftheVote")
    private Double percentageOftheVote;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "candidates_protocolsId")
    @JsonBackReference
    @ToString.Exclude
    private Protocol protocol;
}
