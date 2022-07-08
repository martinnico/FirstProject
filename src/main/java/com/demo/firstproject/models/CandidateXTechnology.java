package com.demo.firstproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name="candidateXTechnology")
@Entity
public class CandidateXTechnology {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "El candidato no puede estar vacio")
    @ManyToOne
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    private Candidate candidate;

    @NotBlank(message =  "La tecnologia no puede estar vacia")
    @ManyToOne
    @JoinColumn(name = "technologyModel",referencedColumnName = "idTechnology")
    private Technology technology;

    private String experience;

    
}
