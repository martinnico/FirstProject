package com.demo.firstproject.testUtils;

import com.demo.firstproject.models.TechnologyModel;
import com.demo.firstproject.models.dto.CandidateDto;
import com.demo.firstproject.models.enums.TypeOfDni;

public class TestEntityFactory {

    public static CandidateDto createCandidateDto () {
        CandidateDto candidateDto = CandidateDto
                .builder()
                .name("martin")
                .lastName("puebla")
                .documentNumber(691815)
                .typeDni(TypeOfDni.DNI)
                .build();
                return  candidateDto;


    }

    public static TechnologyModel createTechnologyModel (){
        TechnologyModel technologyModel = TechnologyModel
                .builder()
                .nameTechnology("java")
                .version("6")
                .build();
        return technologyModel;

    }

}
