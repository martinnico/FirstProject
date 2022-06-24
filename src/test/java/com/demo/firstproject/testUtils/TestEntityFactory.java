package com.demo.firstproject.testUtils;

import com.demo.firstproject.models.CandidateModel;
import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.models.TechnologyModel;
import com.demo.firstproject.models.dto.CandidateDto;
import com.demo.firstproject.models.dto.CandidateXTEchnologyDto;
import com.demo.firstproject.models.enums.TypeOfDni;

import java.util.ArrayList;
import java.util.List;

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

    public static CandidateModel createCandidateModel () {
        CandidateModel candidateModel = CandidateModel
                .builder()
                .name("martin")
                .lastName("puebla")
                .documentNumber(691815)
                .typeDni(TypeOfDni.DNI)
                .build();
        return candidateModel;
    }

    public static TechnologyModel createTechnologyModel (){
        TechnologyModel technologyModel = TechnologyModel
                .builder()
                .idTechnology(1L)
                .nameTechnology("java")
                .version("6")
                .build();
        return technologyModel;

    }

    public static CandidateXTechnologyModel createCandidateXTEchnologyModel (){
        CandidateXTechnologyModel candidateXTechnologyModel = CandidateXTechnologyModel
                .builder()
                .id(1L)
                .experience("5")
                .build();
        return candidateXTechnologyModel;
    }


    public static List <CandidateDto> candidateDtoList (){
        List <CandidateDto> lista = new ArrayList<>();
        lista.add(createCandidateDto());
        return lista;
    }

    public static List <CandidateModel> candidateModelList () {
        List<CandidateModel> lista = new ArrayList<>();
        lista.add(createCandidateModel());
        return lista;
    }

    }


