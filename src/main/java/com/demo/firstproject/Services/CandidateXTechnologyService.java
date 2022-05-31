package com.demo.firstproject.Services;

import com.demo.firstproject.Model.CandidateXTechnologyModel;
import com.demo.firstproject.Model.Dto.CandidateXTEchnologyDto;
import com.demo.firstproject.Repositorys.CandidateXTechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateXTechnologyService {
    @Autowired
    private CandidateXTechnologyRepository candidateXTechnologyRepository;

    public List<CandidateXTechnologyModel> getCandidateXTechnology()
    {
        return  candidateXTechnologyRepository.findAll();
    }

    public CandidateXTechnologyModel createCandidateXTechnology(CandidateXTechnologyModel candidateXTechnology)
    {
            return candidateXTechnologyRepository.save(candidateXTechnology);
    }

    public CandidateXTechnologyModel updateCandidateXTechnology(Long id, CandidateXTechnologyModel candidateXTechnology){
        Optional<CandidateXTechnologyModel> result = candidateXTechnologyRepository.findById(id);
        if(result.isPresent()){
            return candidateXTechnologyRepository.save(candidateXTechnology);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("El id " + id + "No existe"));
        }
    }

    public void deleteCandidateXTechnology (Long id){


        Optional<CandidateXTechnologyModel> result = candidateXTechnologyRepository.findById(id);
        if(result.isPresent()){
            candidateXTechnologyRepository.delete(result.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("El id" +" "+ id +" "+ "no existe" ));
        }
    }



    public CandidateXTEchnologyDto findCandidateXTechnologyDto(Long candidateId){
        CandidateXTechnologyModel candidateXTechnology = candidateXTechnologyRepository.findByCandidateId(candidateId);
        return CandidateXTEchnologyDto.builder()
                .name(candidateXTechnology.getCandidate().getName())
                .nameTechnology(candidateXTechnology.getTechnologyModel().getNameTechnology())
                .experience(candidateXTechnology.getExperience())
                .build();
    }
}
