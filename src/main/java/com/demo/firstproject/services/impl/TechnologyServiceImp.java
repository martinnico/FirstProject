
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
import com.demo.firstproject.models.Technology;


@Slf4j
@Service
public class TechnologyServiceImp implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;


    public List<Technology> getTechnology() {
        return  technologyRepository.findAll();
    }

    public void createTechnology(TechnologyDto technologyDto)
    {
         technologyRepository.save(Technology.builder()
                        .nameTechnology(technologyDto.getNameTechnology())
                        .version(technologyDto.getVersion())
                        .build());
         log.debug("Se ha agregado la tecnologia: "+technologyDto);
    }

    public void updateTechnology(Long id, TechnologyDto technologyDto) {
        Technology result = technologyRepository.findById(id).orElseThrow(() -> new TechnologyNotFoundException("Tecnologia no encontrada "));
        try {
        if (result != null) {
            result = Technology.builder()
                    .nameTechnology(technologyDto.getNameTechnology())
                    .version(technologyDto.getVersion())
                    .build();
            technologyRepository.save(result);
            log.debug("Se actualizo la tecnologia: "+ result);
        }
        } catch (TechnologyNotFoundException t){
            log.error("La tecnologia con id: ",t);
        }
    }

    public void deleteTechnology (Long id){
        Optional<Technology> result = technologyRepository.findById(id);
        try {
            if (result.isPresent()) {
                technologyRepository.delete(result.get());
                log.debug("se elimino la tecnologia: "+result);
            }
        }catch (TechnologyNotFoundException t){
            log.error("La tecnologia con el id:",t);
        }
    }



    public TechnologyDto findTechnologyDto (Long id){
        Technology technology = technologyRepository.findById(id).orElseThrow(()->new TechnologyNotFoundException("Tecnologia no encontrada "));
        TechnologyDto technologyDto;
            log.debug("Se mostrara la tecnologia: " + technology);
             technologyDto= TechnologyDto.builder()
                    .nameTechnology(technology.getNameTechnology())
                    .version(technology.getVersion())
                    .build();
            return technologyDto;
    }
}
