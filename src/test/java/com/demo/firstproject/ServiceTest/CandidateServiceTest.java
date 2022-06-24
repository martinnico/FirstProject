package com.demo.firstproject.ServiceTest;

import com.demo.firstproject.models.CandidateModel;
import com.demo.firstproject.repository.CandidateRepository;
import com.demo.firstproject.services.impl.CandidateServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateDto;
import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateModel;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CandidateServiceTest extends AbstractMVCService {


    @InjectMocks
    CandidateServiceImp candidateServiceImp;
    @Mock
    CandidateRepository candidateRepository;



    @Test
    void getCandidateTest (){
        List<CandidateModel> list = candidateServiceImp.getCandidate();
        List<CandidateModel> list2 = new ArrayList<>();
        when(candidateRepository.findAll()).thenReturn(list2);
        verify(candidateRepository,times(1)).findAll();
        assertEquals(list, candidateRepository.findAll());

    }

    @Test
    void createCandidateTest (){
        when(candidateRepository.save(createCandidateModel())).thenReturn(createCandidateModel());
        candidateServiceImp.createCandidate(createCandidateDto());
        verify(candidateRepository,times(1)).save(createCandidateModel());

    }

    @Test
    void updateCandidateTest (){

        when(candidateRepository.save(createCandidateModel())).thenReturn(createCandidateModel());
        candidateServiceImp.updateCandidate(1L,createCandidateDto());
        verify(candidateRepository,times(1)).save((createCandidateModel()));

    }


    @Test
    void deleteCandidate (){

    }

}
