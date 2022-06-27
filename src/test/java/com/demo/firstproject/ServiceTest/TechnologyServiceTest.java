package com.demo.firstproject.ServiceTest;

import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.models.TechnologyModel;
import com.demo.firstproject.repository.CandidateXTechnologyRepository;
import com.demo.firstproject.repository.TechnologyRepository;
import com.demo.firstproject.services.impl.CandidateXTechnologyServiceImp;
import com.demo.firstproject.services.impl.TechnologyServiceImp;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateDto;
import static com.demo.firstproject.testUtils.TestEntityFactory.createCandidateXTEchnologyModel;
import static com.demo.firstproject.testUtils.TestEntityFactory.createTechnologyDto;
import static com.demo.firstproject.testUtils.TestEntityFactory.createTechnologyModel;
import static com.demo.firstproject.testUtils.TestEntityFactory.technologyModelList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TechnologyServiceTest {

    @InjectMocks
    TechnologyServiceImp technologyServiceImp;
    @Mock
    TechnologyRepository technologyRepository;


    @Test
    void getTechnologyTest() {

        List<TechnologyModel> list = new ArrayList<>();
        list.add(createTechnologyModel());
        when(technologyRepository.findAll()).thenReturn(technologyModelList());
        assertEquals(list, technologyServiceImp.getTechnology());

    }

    @Test
    void createTechnology() {

        when(technologyRepository.save(createTechnologyModel())).thenReturn(createTechnologyModel());
        technologyServiceImp.createTechnology(createTechnologyDto());
        verify(technologyRepository, times(1)).save(createTechnologyModel());

    }

    @Nested
    class updateTechnologyTest {
        @Test
        void updateTechnologyTest() {

            when(technologyRepository.findById(1L)).thenReturn(Optional.of(createTechnologyModel()));

        }

    }
}
