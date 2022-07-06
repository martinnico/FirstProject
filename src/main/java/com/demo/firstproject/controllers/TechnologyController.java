package com.demo.firstproject.controllers;

import com.demo.firstproject.models.dto.TechnologyDto;
import com.demo.firstproject.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.firstproject.models.Technology;
import java.util.List;

@RestController
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService service;

    @GetMapping
    public ResponseEntity <List<Technology>> getTechnology(){
        return new ResponseEntity<>(service.getTechnology(),HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Technology> createTechnology(@RequestBody TechnologyDto technologyDto) {
        service.createTechnology(technologyDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technology> updateTechnology(@PathVariable ("id") Long id, @RequestBody TechnologyDto technologyDto) {
        service.updateTechnology(id,technologyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable ("id") Long id) {
        service.deleteTechnology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnologyDto> findTechnologyDtoById(@PathVariable Long id){
        return new ResponseEntity<>(service.findTechnologyDto(id), HttpStatus.OK);
    }
}


