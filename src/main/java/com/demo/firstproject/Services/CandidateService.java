
package com.demo.firstproject.Services;

import java.util.List;
import java.util.Optional;

import com.demo.firstproject.Model.CandidateModel;
import com.demo.firstproject.Model.Dto.CandidateDto;
import com.demo.firstproject.Repositorys.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CandidateService {

    @Autowired
    private CandidateRepository repository;
    

    public List<CandidateModel> getCandidate() {
        return  repository.findAll();
    }
            
    public CandidateModel createCandidate(CandidateModel candidate){
        return repository.save(candidate);
    }

    public CandidateModel updateCandidate(Long id, CandidateModel candidate){
        Optional<CandidateModel> result = repository.findById(id);
        if(result.isPresent()){
        return repository.save(candidate);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("El id "+id+" no existe"));
        }
    }

    public void deleteCandidate (Long id){

        //candidateRepository.deleteById(id);
        Optional<CandidateModel> result = repository.findById(id);
        if(result.isPresent()){
            repository.delete(result.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("El id " +id+" No existe"));
        }
    }

    @Autowired
    private CandidateRepository candidateRepository;
    public CandidateDto findCandidateDto (Long id){
        CandidateModel candidateModel = candidateRepository.getById(id);
        return  CandidateDto.builder()
                .name(candidateModel.getName())
                .lastName(candidateModel.getLastName())
                .build();

    }
}
