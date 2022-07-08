package com.demo.firstproject.controllers;

import com.demo.firstproject.models.CandidateXTechnology;
import com.demo.firstproject.models.dto.CandidateXTechnologyDto;
import com.demo.firstproject.projections.ListCandidatesProjection;
import com.demo.firstproject.services.impl.CandidateXTechnologyServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

        @Operation(summary = "Show All Experiences")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
        })
        @GetMapping
        public ResponseEntity <List<CandidateXTechnology>> getCandidateXTechnology(){
            return new ResponseEntity<>(service.getCandidateXTechnology(),HttpStatus.OK);

        }
         @Operation(summary = "Create Experiences")
         @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = @Content)
          })
        @PostMapping
        public ResponseEntity<CandidateXTechnology> createCandidateXTechnology(@RequestBody CandidateXTechnologyDto candidateXTechnologyDtoSend) {
            service.createCandidateXTechnology(candidateXTechnologyDtoSend);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @Operation(summary = "Update Experience by Id")
        @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully updated Experience", content = @Content),
        @ApiResponse(responseCode = "404", description = "Experience ID not found", content = @Content)
            })
        @PutMapping("/{id}")
        public ResponseEntity<CandidateXTechnology> updateCandidateXTechnology(@PathVariable ("id") Long id, @RequestBody CandidateXTechnologyDto candidateXTechnologyDtoSend) {
            service.updateCandidateXTechnology(id,candidateXTechnologyDtoSend);
            return new ResponseEntity<>(HttpStatus.OK);
        }

         @Operation(summary = "Delete Experience by Id")
         @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted Experience", content = @Content),
            @ApiResponse(responseCode = "404", description = "Experience not found", content = @Content)
    })
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCandidateXTechnology(@PathVariable ("id") Long id){
            service.deleteCandidateXTechnology(id);
            return new ResponseEntity<> (HttpStatus.OK) ;
        }

         @Operation(summary = "Get All Experiences by Candidates Id")
            @ApiResponses(value = {
                @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
                @ApiResponse(responseCode = "404", description = "Candidate Id not found", content = @Content)
    })
        @GetMapping(value = "/dto/{candidateId}")
        public ResponseEntity<CandidateXTechnologyDto>findCandidateXTechnologyDto(@PathVariable Long candidateId){
            return new ResponseEntity<>(service.findCandidateXTechnologyDto(candidateId),HttpStatus.OK);
    }

    @Operation(summary = "Get All Experiences")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
    })
        @GetMapping(value = "/listcandidate")
        public ResponseEntity<List<ListCandidatesProjection>> listCandidateXTechnology(@PathVariable String technology){
            return new ResponseEntity<>(service.listCandidatesXTechnologies(technology),HttpStatus.OK);
        }

}
