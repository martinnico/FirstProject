package com.demo.firstproject.services.impl;

import com.demo.firstproject.exception.CandidateXTechnologyNotFound;
import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.models.dto.CandidateXTEchnologyDto;
import com.demo.firstproject.models.dto.CandidateXTechnologyDtoSend;
import com.demo.firstproject.projections.ListCandidates;
import com.demo.firstproject.repository.CandidateXTechnologyRepository;
import com.demo.firstproject.services.CandidateXTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateXTechnologyServiceImp implements CandidateXTechnologyService {
    @Autowired
    private CandidateXTechnologyRepository candidateXTechnologyRepository;

    public List<CandidateXTechnologyModel> getCandidateXTechnology()
    {
        return  candidateXTechnologyRepository.findAll();
    }

    public CandidateXTechnologyModel createCandidateXTechnology(CandidateXTechnologyDtoSend candidateXTechnologyDtoSend)
    {
        CandidateXTechnologyModel candidateXTechnologyModel = CandidateXTechnologyModel
                .builder()
                .candidate(candidateXTechnologyDtoSend.getCandidate())
                .technologyModel(candidateXTechnologyDtoSend.getTechnology())
                .experience(candidateXTechnologyDtoSend.getExperience())
                .build();
            return candidateXTechnologyRepository.save(candidateXTechnologyModel);
    }

    public CandidateXTechnologyModel updateCandidateXTechnology(Long id, CandidateXTechnologyDtoSend candidateXTechnologyDtoSend){
        Optional<CandidateXTechnologyModel> result = candidateXTechnologyRepository.findById(id);
        if(result.isPresent()){
            result.get().setCandidate(candidateXTechnologyDtoSend.getCandidate());
            result.get().setTechnologyModel(candidateXTechnologyDtoSend.getTechnology());
            result.get().setExperience(candidateXTechnologyDtoSend.getExperience());
            return candidateXTechnologyRepository.save(result.get());
        }
        else {
            throw new CandidateXTechnologyNotFound("El id "+ id + "no existe");
        }
    }

    public void deleteCandidateXTechnology (Long id){


        Optional<CandidateXTechnologyModel> result = candidateXTechnologyRepository.findById(id);
        if(result.isPresent()){
            candidateXTechnologyRepository.delete(result.get());
        }
        else {
            throw new CandidateXTechnologyNotFound("El id "+ id + "no existe");        }
    }



    public CandidateXTEchnologyDto findCandidateXTechnologyDto(Long candidateId){
        CandidateXTechnologyModel candidateXTechnology = candidateXTechnologyRepository.findByCandidateId(candidateId);
        return CandidateXTEchnologyDto.builder()
                .name(candidateXTechnology.getCandidate().getName())
                .nameTechnology(candidateXTechnology.getTechnologyModel().getNameTechnology())
                .experience(candidateXTechnology.getExperience())
                .build();
    }

    public List<ListCandidates> listCandidatesXTechnologies(String technology){
         return candidateXTechnologyRepository.listCandidatesXTechnology(technology);
    }
}
