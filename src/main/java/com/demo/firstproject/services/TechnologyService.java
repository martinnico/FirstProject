package com.demo.firstproject.services;

import com.demo.firstproject.models.Technology;
import com.demo.firstproject.models.dto.TechnologyDto;

import java.util.List;

public interface TechnologyService {

     List<Technology> getTechnology();

     void createTechnology(TechnologyDto technologyDto);

     void updateTechnology(Long id, TechnologyDto technologyDto);

     void deleteTechnology (Long id);

     TechnologyDto findTechnologyDto (Long id);
}
