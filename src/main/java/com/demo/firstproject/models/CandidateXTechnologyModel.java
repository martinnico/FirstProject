package com.demo.firstproject.models;

import javax.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name="candidateXTechnology")
@Entity
public class CandidateXTechnologyModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    private CandidateModel candidate;

    @ManyToOne
    @JoinColumn(name = "technologyModel",referencedColumnName = "idTechnology")
    private TechnologyModel technologyModel;

    private String experience;

    
}
