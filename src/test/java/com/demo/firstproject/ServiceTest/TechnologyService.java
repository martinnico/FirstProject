package com.demo.firstproject.ServiceTest;


import com.demo.firstproject.exception.TechnologyNotFoundException;
import com.demo.firstproject.models.Technology;
import com.demo.firstproject.repository.TechnologyRepository;
import com.demo.firstproject.services.impl.TechnologyServiceImp;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.demo.firstproject.testUtils.TestEntityFactory.createTechnologyDto;
import static com.demo.firstproject.testUtils.TestEntityFactory.createTechnologyModel;
import static com.demo.firstproject.testUtils.TestEntityFactory.technologyModelList;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TechnologyService extends AbstractMVCService{

    @InjectMocks
    TechnologyServiceImp technologyServiceImp;
    @Mock
    TechnologyRepository technologyRepository;


    @Test
    void getTechnologyTest() {

        List<Technology> list = new ArrayList<>();
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
            technologyServiceImp.updateTechnology(1L,createTechnologyDto());
            verify(technologyRepository,times(1)).findById(1L);
        }

        @Test
        void updateTechnologyTestFail (){
            when(technologyRepository.findById(2L)).thenThrow(TechnologyNotFoundException.class);
            assertThrows(TechnologyNotFoundException.class, () -> technologyServiceImp.updateTechnology(2L, createTechnologyDto()));
        }
    }

    @Nested
    class deleteTechnologyTest {

        @Test
        void deleteTechnologyTest (){

            when(technologyRepository.findById(1L)).thenReturn(Optional.of(createTechnologyModel()));
            technologyRepository.delete(createTechnologyModel());
            verify(technologyRepository,times(1)).delete(createTechnologyModel());
            technologyServiceImp.deleteTechnology(1L);

        }

        @Test
        void deleteTechnologyTestFail (){
            when(technologyRepository.findById(2L)).thenThrow(TechnologyNotFoundException.class);
            assertThrows(TechnologyNotFoundException.class, () -> technologyServiceImp.deleteTechnology(2L));
        }
    }

    @Test
    void findTechnologyDtoTest () {

        when(technologyRepository.getById(1L)).thenReturn(createTechnologyModel());
        technologyServiceImp.findTechnologyDto(1L);
        verify(technologyRepository,times(1)).findById(1L);

    }
}
