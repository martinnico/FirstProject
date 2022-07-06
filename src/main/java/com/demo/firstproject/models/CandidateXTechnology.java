package com.demo.firstproject.models;

import javax.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name="candidateXTechnology")
@Entity
public class CandidateXTechnology {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "technologyModel",referencedColumnName = "idTechnology")
    private Technology technology;

    private String experience;

    
}
