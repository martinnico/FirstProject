
package com.demo.firstproject.services.impl;

import java.util.List;
import java.util.Optional;

import com.demo.firstproject.exception.TechnologyNotFoundException;
import com.demo.firstproject.models.dto.TechnologyDto;
import com.demo.firstproject.repository.TechnologyRepository;
import com.demo.firstproject.services.TechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.firstproject.models.TechnologyModel;


@Slf4j
@Service
public class TechnologyServiceImp implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;


    public List<TechnologyModel> getTechnology() {
        return  technologyRepository.findAll();
    }

    public void createTechnology(TechnologyDto technologyDto)
    {
         technologyRepository.save(TechnologyModel.builder()
                        .nameTechnology(technologyDto.getNameTechnology())
                        .version(technologyDto.getVersion())
                        .build());
         log.debug("Se ha agregado la tecnologia: "+technologyDto);
    }

    public void updateTechnology(Long id, TechnologyDto technologyDto) {
        TechnologyModel result = technologyRepository.findById(id).orElseThrow(() -> new TechnologyNotFoundException("Tecnologia no encontrada "));
        try {
        if (result != null) {
            result = TechnologyModel.builder()
                    .nameTechnology(technologyDto.getNameTechnology())
                    .version(technologyDto.getVersion())
                    .build();
            technologyRepository.save(result);
        }
        } catch (TechnologyNotFoundException t){
            log.error("La tecnologia con id: "+id+" no se ha encontrado");
        }
    }

    public void deleteTechnology (Long id){
        Optional<TechnologyModel> result = technologyRepository.findById(id);
        try {
            if (result.isPresent()) {
                technologyRepository.delete(result.get());
            }
        }catch (TechnologyNotFoundException t){
            log.error("La tecnologia con el id: "+id+" no se ha encontrado");
        }
    }



    public TechnologyDto findTechnologyDto (Long id){
        TechnologyModel technologyModel = technologyRepository.findById(id).orElseThrow(()->new TechnologyNotFoundException("Tecnologia no encontrada "));;
        return  TechnologyDto.builder()
                .nameTechnology(technologyModel.getNameTechnology())
                .version(technologyModel.getVersion())
                .build();

    }
}
