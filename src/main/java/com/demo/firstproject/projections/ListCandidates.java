package com.demo.firstproject.projections;

import com.demo.firstproject.models.enums.TypeOfDni;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface ListCandidates {

    @Value("#{target.name}")
    String getNameCandidate();

    @Value("#{target.last_name}")
    String getLastNameCandidate();

    @Value("#{target.document_number}")
    Long getDocumentNumberCandidate();

    @Value("#{target.date_of_birth}")
    Date getDateOfBirthCandidate();

    @Value("#{target.type_dni}")
    TypeOfDni getTypeOfDniCandidate();

    @Value("#{target.experience}")
    String experienceCandidate();

    @Value("#{target.name_technology}")
    String nameOfTechnology();

}
