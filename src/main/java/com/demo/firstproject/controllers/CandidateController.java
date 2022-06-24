package com.demo.firstproject.controllers;

import com.demo.firstproject.models.CandidateModel;
import com.demo.firstproject.models.dto.CandidateDto;
import com.demo.firstproject.services.CandidateService;
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
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping
    public ResponseEntity<List<CandidateModel>> getCandidate() {
        return new ResponseEntity<>(service.getCandidate(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<HttpStatus> createCandidates(@RequestBody CandidateDto candidate) {
        service.createCandidate(candidate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateCandidates(@PathVariable("id") Long id, @RequestBody CandidateDto candidate) {
        service.updateCandidate(id, candidate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCandidate(@PathVariable("id") Long id) {
        service.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CandidateDto> findCandidateDtoById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findCandidateDto(id), HttpStatus.OK);
    }


}
    

