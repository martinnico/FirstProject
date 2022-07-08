package com.demo.firstproject.controllers;

import com.demo.firstproject.models.Candidate;
import com.demo.firstproject.models.dto.CandidateDto;
import com.demo.firstproject.services.CandidateService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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

    @Operation(summary = "Show All Candidates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
    })
    @GetMapping
    public ResponseEntity<List<Candidate>> getCandidate() {
        return new ResponseEntity<>(service.getCandidate(), HttpStatus.OK);

    }

    @Operation(summary = "Create Candidates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = @Content)
    })
    @PostMapping
    public ResponseEntity<HttpStatus> createCandidates(@RequestBody CandidateDto candidate) {
        service.createCandidate(candidate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Update Candidate by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully updated Candidate", content = @Content),
            @ApiResponse(responseCode = "404", description = "Candiate ID not found", content = @Content),

    })
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateCandidates(@PathVariable("id") Long id, @RequestBody CandidateDto candidate) {
        service.updateCandidate(id, candidate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Delete Candidate by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted Candidate", content = @Content),
            @ApiResponse(responseCode = "404", description = "Candidate not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCandidate(@PathVariable("id") Long id) {
        service.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Get All Candidates by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Candidate Id not found", content = @Content)
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<CandidateDto> findCandidateDtoById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findCandidateDto(id), HttpStatus.OK);
    }


}
    

