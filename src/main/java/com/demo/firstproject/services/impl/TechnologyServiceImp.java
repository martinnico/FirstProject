
package com.demo.firstproject.services.impl;

import java.util.List;
import java.util.Optional;

import com.demo.firstproject.models.dto.TechnologyDto;
import com.demo.firstproject.repository.TechnologyRepository;
import com.demo.firstproject.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.demo.firstproject.models.TechnologyModel;


@Service
public class TechnologyServiceImp implements TechnologyService {

    @Autowired
    private TechnologyRepository repository;
    @Autowired
    private TechnologyRepository technologyRepository;

    public List<TechnologyModel> getTechnology() {
        return  repository.findAll();
    }

    public TechnologyModel createTechnology(TechnologyModel technology){
        return repository.save(technology);
    }

    public TechnologyModel updateTechnology(Long id, TechnologyModel technology){
        Optional<TechnologyModel> result = repository.findById(id);
        if(result.isPresent()){
            return repository.save(technology);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("El id " + id + " no existe"));
        }
    }

    public void deleteTechnology (Long id){
        Optional<TechnologyModel> result = repository.findById(id);
        if(result.isPresent()){
            repository.delete(result.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("El id " + id + "no existe"));
        }
    }



    public TechnologyDto findTechnologyDto (Long id){
        TechnologyModel technologyModel = technologyRepository.getById(id);
        return  TechnologyDto.builder()
                .nameTechnology(technologyModel.getNameTechnology())
                .version(technologyModel.getVersion())
                .build();

    }
}
