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
import com.demo.firstproject.models.TechnologyModel;
import java.util.List;

@RestController
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService service;

    @GetMapping
    public ResponseEntity <List<TechnologyModel>> getTechnology(){
        return new ResponseEntity<>(service.getTechnology(),HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<TechnologyModel> createTechnology(@RequestBody TechnologyModel technology) {
        return new ResponseEntity<>(service.createTechnology(technology),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyModel> updateTechnology(@PathVariable ("id") Long id,@RequestBody TechnologyModel technology) {
        return new ResponseEntity<>(service.updateTechnology(id,technology),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable ("id") Long id) {
        service.deleteTechnology(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnologyDto> findTechnologyDtoById(@PathVariable Long id){
        return new ResponseEntity<>(service.findTechnologyDto(id), HttpStatus.OK);
    }
}


