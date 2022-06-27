package com.demo.firstproject.ServiceTest;

import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.repository.CandidateRepository;
import com.demo.firstproject.repository.CandidateXTechnologyRepository;
import com.demo.firstproject.services.impl.CandidateServiceImp;
import com.demo.firstproject.services.impl.CandidateXTechnologyServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.demo.firstproject.models.CandidateModel;
import com.demo.firstproject.repository.CandidateRepository;
import com.demo.firstproject.services.impl.CandidateServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateDto;
import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateModel;
import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateXTEchnologyModel;
import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateXTechnologyDtoSend;
import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateXTechnologyModelList;
import static com.demo.firstproject.testUtils.TestEntityFactory.getCandidateByTechnologyProjectionList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CandidateXTechnologyServiceTest extends AbstractMVCService {

    @InjectMocks
    CandidateXTechnologyServiceImp candidateXTechnologyServiceImp;
    @Mock
    CandidateXTechnologyRepository candidateXTechnologyRepository;


    @Test
    void getCandidateXTechnologyTest (){

        List<CandidateXTechnologyModel> list = new ArrayList<>();
        list.add(createCandidateXTEchnologyModel());
        when(candidateXTechnologyRepository.findAll()).thenReturn(createCandidateXTechnologyModelList());
        assertEquals(list,candidateXTechnologyServiceImp.getCandidateXTechnology());
    }

    @Test
    void createCandidateXTechnologyTest () {

        when(candidateXTechnologyRepository.save(createCandidateXTEchnologyModel())).thenReturn(createCandidateXTEchnologyModel());
        candidateXTechnologyServiceImp.createCandidateXTechnology(createCandidateXTechnologyDtoSend());
        verify(candidateXTechnologyRepository,times(1)).save(createCandidateXTEchnologyModel());

    }

    @Test
    void updateCandidateXTechnologyTest () {

        when(candidateXTechnologyRepository.findById(1L)).thenReturn(Optional.of(createCandidateXTEchnologyModel()));
        when(candidateXTechnologyRepository.save(createCandidateXTEchnologyModel())).thenReturn(createCandidateXTEchnologyModel());
        candidateXTechnologyServiceImp.updateCandidateXTechnology(1L, createCandidateXTechnologyDtoSend());
        verify(candidateXTechnologyRepository,times(1)).findById(1L);
        verify(candidateXTechnologyRepository,times(1)).save(createCandidateXTEchnologyModel());

    }

    @Test
    void deleteCandidateXTechnology () {

        when(candidateXTechnologyRepository.findById(1L)).thenReturn(Optional.of(createCandidateXTEchnologyModel()));
        candidateXTechnologyRepository.delete(createCandidateXTEchnologyModel());
        verify(candidateXTechnologyRepository,times(1)).delete(createCandidateXTEchnologyModel());
        candidateXTechnologyServiceImp.deleteCandidateXTechnology(1L);
    }

    @Test
    void findCandidateXTechnologyDtoTest (){

        when(candidateXTechnologyRepository.findByCandidateId(1L)).thenReturn(createCandidateXTEchnologyModel());
        candidateXTechnologyServiceImp.findCandidateXTechnologyDto(1L);
    }

    @Test
    void listCandidatesXTechnologiesTest (){

        when(candidateXTechnologyRepository.listCandidatesXTechnology("JAVA")).thenReturn(getCandidateByTechnologyProjectionList());
        candidateXTechnologyServiceImp.listCandidatesXTechnologies("JAVA");
        verify(candidateXTechnologyRepository,times(1)).listCandidatesXTechnology("JAVA");

    }

}
