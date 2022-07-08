
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
public class Candidate {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty(message = "completar nombre")
    private String name;

    @NotBlank
    @NotEmpty(message = "completar Apellido")
    private String lastName;

    @NotBlank
    @NotEmpty(message = "completar tipo de DNI")
    private TypeOfDni typeDni;

    @NotBlank
    @NotEmpty(message = "completar numero de DNI")
    private long documentNumber;

    @NotBlank
    private boolean active ;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    
}
