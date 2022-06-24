package com.demo.firstproject.controllers;

import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.models.dto.CandidateXTEchnologyDto;
import com.demo.firstproject.projections.Listcandidates;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/candidateXTechnology")
public class CandidateXTechnologyController {

        @Autowired
        private CandidateXTechnologyServiceImp service;

        @GetMapping
        public ResponseEntity <List<CandidateXTechnologyModel>> getCandidateXTechnology(){
            return new ResponseEntity<>(service.getCandidateXTechnology(),HttpStatus.OK);

        }
        @PostMapping
        public ResponseEntity<CandidateXTechnologyModel> createCandidateXTechnology(@RequestBody CandidateXTechnologyModel candidateXTechnology) {
            return new ResponseEntity<>(service.createCandidateXTechnology(candidateXTechnology),HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CandidateXTechnologyModel> updateCandidateXTechnology(@PathVariable ("id") Long id,@RequestBody CandidateXTechnologyModel candidateXTechnology) {
            return new ResponseEntity<>(service.updateCandidateXTechnology(id,candidateXTechnology),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCandidateXTechnology(@PathVariable ("id") Long id){
            service.deleteCandidateXTechnology(id);
            return new ResponseEntity<> (HttpStatus.NO_CONTENT) ;
        }

        @GetMapping(value = "/dto/{candidateId}")
        public ResponseEntity<CandidateXTEchnologyDto> findCandidateXTechnologyDto(@PathVariable Long candidateId){
        return new ResponseEntity<>(service.findCandidateXTechnologyDto(candidateId), HttpStatus.OK);
    }

        @GetMapping(value = "/listcandidate")
        public ResponseEntity<List<Listcandidates>> listCandidateXTechnology(@PathVariable String technology){
            return new ResponseEntity<>(service.listCandidatesXTechnologies(technology),HttpStatus.OK);
        }

}
