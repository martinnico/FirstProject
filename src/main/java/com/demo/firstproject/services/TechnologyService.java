package com.demo.firstproject.services;

import com.demo.firstproject.models.TechnologyModel;
import com.demo.firstproject.models.dto.TechnologyDto;

import java.util.List;

public interface TechnologyService {

     List<TechnologyModel> getTechnology();

     TechnologyModel createTechnology(TechnologyDto technologyDto);

     TechnologyModel updateTechnology(Long id, TechnologyDto technologyDto);

     void deleteTechnology (Long id);

     TechnologyDto findTechnologyDto (Long id);
}
