package com.demo.firstproject.testUtils;

import com.demo.firstproject.models.Candidate;
import com.demo.firstproject.models.CandidateXTechnology;
import com.demo.firstproject.models.Technology;
import com.demo.firstproject.models.dto.CandidateDto;
import com.demo.firstproject.models.dto.CandidateXTechnologyDto;
import com.demo.firstproject.models.dto.TechnologyDto;
import com.demo.firstproject.models.enums.TypeOfDni;
import com.demo.firstproject.projections.ListCandidatesProjection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestEntityFactory {

    public static CandidateDto createCandidateDto () {
        CandidateDto candidateDto = CandidateDto
                .builder()
                .id(1L)
                .name("martin")
                .lastName("puebla")
                .documentNumber(39629298)
                .typeDni(TypeOfDni.DNI)
                .build();
                return  candidateDto;


    }

    public static CandidateXTechnologyDto createCandidateXTechnologyDtoSend (){
        CandidateXTechnologyDto candidateXTechnologyDtoSend = CandidateXTechnologyDto
                .builder()
                .id(1L)
                .candidate(createCandidateModel())
                .technology(createTechnologyModel())
                .experience("3")
                .build();
        return candidateXTechnologyDtoSend;
    }


    public static Candidate createCandidateModel () {
        Candidate candidate = Candidate
                .builder()
                .id(1L)
                .name("martin")
                .lastName("puebla")
                .documentNumber(691815)
                .typeDni(TypeOfDni.DNI)

                .build();
        return candidate;
    }

    public static Technology createTechnologyModel (){
        Technology technology = Technology
                .builder()
                .nameTechnology("JAVA")
                .version("8")
                .build();
        return technology;

    }

    public static TechnologyDto createTechnologyDto (){
        TechnologyDto technologyDto = TechnologyDto
                .builder()
                .nameTechnology("JAVA")
                .version("8")
                .build();
        return  technologyDto;
    }

    public static CandidateDto createCandidateDtoFind (){
        CandidateDto candidateDto = CandidateDto
                .builder()
                .name("martin")
                .lastName("puebla")
                .build();
                return candidateDto;

    }

    public static CandidateXTechnology createCandidateXTEchnologyModel (){
        CandidateXTechnology candidateXTechnology = CandidateXTechnology
                .builder()
                .candidate(createCandidateModel())
                .technology(createTechnologyModel())
                .experience("3")
                .build();
        return candidateXTechnology;
    }

    public static List<CandidateXTechnology> createCandidateXTechnologyModelList (){
        List<CandidateXTechnology> list = new ArrayList<>();
        list.add(createCandidateXTEchnologyModel());
        return list;
    }

    public static List <CandidateDto> candidateDtoList (){
        List <CandidateDto> list = new ArrayList<>();
        list.add(createCandidateDto());
        return list;
    }

    public static List <Candidate> candidateModelList () {
        List<Candidate> list = new ArrayList<>();
        list.add(createCandidateModel());
        return list;
    }

    public static List<Technology> technologyModelList (){
        List<Technology> list = new ArrayList<>();
        list.add(createTechnologyModel());
        return list;
    }
    public static List<ListCandidatesProjection> getCandidateByTechnologyProjectionList() {
        List<ListCandidatesProjection> projectionList = new ArrayList<>();
        projectionList.add(getCandidateByTechnologyProjection());
        return projectionList;
    }

    public static ListCandidatesProjection getCandidateByTechnologyProjection() {
        ListCandidatesProjection candidateByTechnologyProjection = new ListCandidatesProjection() {

            @Override
            public  void setNameCandidate(String nameCandidate) {
            }



            @Override
            public String getNameCandidate() {
                return "martin";
            }

            @Override
            public String getLastNameCandidate() {
                return "puebla";
            }

            @Override
            public void  setLastNameCandidate (String lastNameCandidate) {

            }

            @Override
            public void setDocumentNumberCandidate (Long documentNumberCandidate) {

            }

            @Override
            public Long getDocumentNumberCandidate() {
                return 39629298L;
            }

            @Override
            public void setDateOfBirthCandidate (Date birthdayOfCandidate) {

            }

            @Override
            public Date getDateOfBirthCandidate() {
                return null;
            }

            @Override
            public void setTypeOfDniCandidate (TypeOfDni typeOfDni) {
            }
            @Override
            public TypeOfDni getTypeOfDniCandidate(){
                return TypeOfDni.DNI;
            }

            @Override
            public String getExperienceCandidate(){
                return "5";
            }

            @Override
            public void setExperienceCandidate(String experienceCandidate){

            }

            @Override
            public String getNameOfTechnology(){
                return "JAVA";
            }

            @Override
            public   void setNameOfTechnology(String nameOfTechnology){

            }



        };
        return candidateByTechnologyProjection;
    }


}


