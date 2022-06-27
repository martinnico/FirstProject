
package com.demo.firstproject.models;

import java.util.*;

import com.demo.firstproject.models.enums.TypeOfDni;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="Candidate")
public class CandidateModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "completar nombre")
    private String name;
    
    @NotEmpty(message = "completar Apellido")
    private String lastName;
    
    @NotEmpty(message = "completar tipo de DNI")
    private TypeOfDni typeDni;
    
    @NotEmpty(message = "completar numero de DNI")
    private long documentNumber;

    private boolean active ;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    
}
