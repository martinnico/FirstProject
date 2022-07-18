package com.demo.firstproject.controllers;

import com.demo.firstproject.models.Technology;
import com.demo.firstproject.models.dto.TechnologyDto;
import com.demo.firstproject.services.TechnologyService;
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
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService service;

    @Operation(summary = "Show All Technologies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
    })
    @GetMapping
    public ResponseEntity<List<Technology>> getTechnology() {
        return new ResponseEntity<>(service.getTechnology(), HttpStatus.OK);

    }

    @Operation(summary = "Create Technology")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Technology> createTechnology(@RequestBody TechnologyDto technologyDto) {
        service.createTechnology(technologyDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Update Technology")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully updated Technology", content = @Content),
            @ApiResponse(responseCode = "404", description = "Technology ID not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Technology> updateTechnology
            (@PathVariable("id") Long id, @RequestBody TechnologyDto technologyDto) {
        service.updateTechnology(id, technologyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Delete Technology")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted Technology", content = @Content),
            @ApiResponse(responseCode = "404", description = "Technology not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable("id") Long id) {
        service.deleteTechnology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Get Technology by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Technology Id not found", content = @Content)
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnologyDto> findTechnologyDtoById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findTechnologyDto(id), HttpStatus.OK);
    }
}


