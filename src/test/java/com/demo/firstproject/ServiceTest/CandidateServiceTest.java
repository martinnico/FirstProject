package com.demo.firstproject.ServiceTest;

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
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        candidateRepository.save(createCandidateModel());
        candidateServiceImp.createCandidate(createCandidateDto());
        verify(candidateRepository,times(1)).save(createCandidateModel());

    }

    @Test
    void updateCandidateTest (){

        when(candidateRepository.findById(1L)).thenReturn(Optional.of(createCandidateModel()));
        candidateRepository.save(createCandidateModel());
        verify(candidateRepository,times(1)).save((createCandidateModel()));
        candidateServiceImp.updateCandidate(1L,createCandidateDto());
    }



    @Test
    void deleteCandidateTest (){


        when(candidateRepository.findById(1L))
                        .thenReturn(Optional.of(createCandidateModel()));
        candidateRepository.delete(createCandidateModel());
        verify(candidateRepository,times(1)).delete(createCandidateModel());

        candidateServiceImp.deleteCandidate(createCandidateModel().getId());

        assertTrue(!createCandidateModel().isActive());
    }

    @Test
    void findCandidateDtoTest () {

        when(candidateRepository.getById(1L)).thenReturn(createCandidateModel());
        candidateServiceImp.findCandidateDto(1L);
        verify(candidateRepository,times(1)).getById(1L);

    }

}
