
package com.demo.firstproject.Controller;

import com.demo.firstproject.Model.CandidateModel;
import com.demo.firstproject.Model.Dto.CandidateDto;
import com.demo.firstproject.Services.CandidateService;
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
    public ResponseEntity <List<CandidateModel>> getCandidate(){
        return new ResponseEntity<List<CandidateModel>>(service.getCandidate(),HttpStatus.OK);

    }
     @PostMapping
    public ResponseEntity<CandidateModel> createCandidates(@RequestBody CandidateModel candidate) {
        return new ResponseEntity<CandidateModel>(service.createCandidate(candidate),HttpStatus.CREATED);
     }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateModel> updateCandidates(@PathVariable ("id") Long id,@RequestBody CandidateModel candidate) {
        return new ResponseEntity<CandidateModel>(service.updateCandidate(id,candidate),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable ("id") Long id){
        service.deleteCandidate(id);
       return new ResponseEntity<Void> (HttpStatus.NO_CONTENT) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CandidateDto> findCandidateDtoById(@PathVariable ("id") Long id){
        deleteCandidate(id);
        return new ResponseEntity<>(service.findCandidateDto(id), HttpStatus.OK);
    }


   }
    

