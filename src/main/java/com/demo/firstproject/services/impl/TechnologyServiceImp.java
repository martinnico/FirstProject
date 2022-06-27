
package com.demo.firstproject.services.impl;

import java.util.List;
import java.util.Optional;

import com.demo.firstproject.exception.TechnologyNotFound;
import com.demo.firstproject.models.dto.TechnologyDto;
import com.demo.firstproject.repository.TechnologyRepository;
import com.demo.firstproject.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.firstproject.models.TechnologyModel;



@Service
public class TechnologyServiceImp implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;


    public List<TechnologyModel> getTechnology() {
        return  technologyRepository.findAll();
    }

    public TechnologyModel createTechnology(TechnologyDto technologyDto)
    {
        return technologyRepository.save(TechnologyModel.builder()
                        .nameTechnology(technologyDto.getNameTechnology())
                        .version(technologyDto.getVersion())
                        .build());
    }

    public TechnologyModel updateTechnology(Long id, TechnologyDto technologyDto){
        Optional<TechnologyModel> result = technologyRepository.findById(id);
        if(result.isPresent()){
            result.get().setNameTechnology(technologyDto.getNameTechnology());
            result.get().setVersion(technologyDto.getVersion());
            return technologyRepository.save(result.get());
        }
        else {
            throw new TechnologyNotFound("El id :"+ id + " no existe");
        }
    }

    public void deleteTechnology (Long id){
        Optional<TechnologyModel> result = technologyRepository.findById(id);
        if(result.isPresent()){
            technologyRepository.delete(result.get());
        }
        else {
            throw new TechnologyNotFound("EL id: "+ id + " no existe");
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
