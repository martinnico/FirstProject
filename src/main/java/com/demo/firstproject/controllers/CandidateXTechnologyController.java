package com.demo.firstproject.controllers;

import com.demo.firstproject.models.CandidateXTechnology;
import com.demo.firstproject.models.dto.CandidateXTechnologyDto;
import com.demo.firstproject.projections.ListCandidatesProjection;
import com.demo.firstproject.services.impl.CandidateXTechnologyServiceImp;
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
import java.util.List;

@RestController
@RequestMapping("/candidateXTechnology")
public class CandidateXTechnologyController {

        @Autowired
        private CandidateXTechnologyServiceImp service;

        @GetMapping
        public ResponseEntity <List<CandidateXTechnology>> getCandidateXTechnology(){
            return new ResponseEntity<>(service.getCandidateXTechnology(),HttpStatus.OK);

        }
        @PostMapping
        public ResponseEntity<CandidateXTechnology> createCandidateXTechnology(@RequestBody CandidateXTechnologyDto candidateXTechnologyDtoSend) {
            service.createCandidateXTechnology(candidateXTechnologyDtoSend);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CandidateXTechnology> updateCandidateXTechnology(@PathVariable ("id") Long id, @RequestBody CandidateXTechnologyDto candidateXTechnologyDtoSend) {
            service.updateCandidateXTechnology(id,candidateXTechnologyDtoSend);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCandidateXTechnology(@PathVariable ("id") Long id){
            service.deleteCandidateXTechnology(id);
            return new ResponseEntity<> (HttpStatus.NO_CONTENT) ;
        }

        @GetMapping(value = "/dto/{candidateId}")
        public ResponseEntity<CandidateXTechnologyDto> findCandidateXTechnologyDto(@PathVariable Long candidateId){
            service.findCandidateXTechnologyDto(candidateId);
            return new ResponseEntity<>(HttpStatus.OK);
    }

        @GetMapping(value = "/listcandidate")
        public ResponseEntity<List<ListCandidatesProjection>> listCandidateXTechnology(@PathVariable String technology){
            return new ResponseEntity<>(service.listCandidatesXTechnologies(technology),HttpStatus.OK);
        }

}
