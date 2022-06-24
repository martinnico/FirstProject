package com.demo.firstproject.models.dto;


import com.demo.firstproject.models.enums.TypeOfDni;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDto {
    private Long id;
    private String name;
    private String lastName;
    private TypeOfDni typeDni;
    private long documentNumber;
    private Date dateOfBirth;
}
