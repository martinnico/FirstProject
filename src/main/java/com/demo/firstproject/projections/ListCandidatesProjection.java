package com.demo.firstproject.projections;

import com.demo.firstproject.models.enums.TypeOfDni;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface ListCandidatesProjection {

    @Value("#{target.name}")
    String getNameCandidate();

    @Value("#{target.name}")
    void setNameCandidate( String nameCandidate);

    @Value("#{target.last_name}")
    String getLastNameCandidate();

    @Value("#{target.last_name}")
    void  setLastNameCandidate(String lastNameCandidate);

    @Value("#{target.document_number}")
    Long getDocumentNumberCandidate();

    @Value("#{target.document_number}")
    void setDocumentNumberCandidate(Long documentNumberCandidate);

    @Value("#{target.date_of_birth}")
    Date getDateOfBirthCandidate();

    @Value("#{target.date_of_birth}")
    void setDateOfBirthCandidate(Date birthOfCandidate);

    @Value("#{target.type_dni}")
    TypeOfDni getTypeOfDniCandidate();

    @Value("#{target.type_dni}")
    void setTypeOfDniCandidate(TypeOfDni typeOfDniCandidate);

    @Value("#{target.experience}")
    String getExperienceCandidate();

    @Value("#{target.experience}")
    void setExperienceCandidate(String experienceCandidate);

    @Value("#{target.name_technology}")
    String getNameOfTechnology();

    @Value("#{target.name_technology}")
    void setNameOfTechnology(String nameOfTechnology);

}
