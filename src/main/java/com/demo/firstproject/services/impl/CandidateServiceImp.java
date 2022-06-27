
package com.demo.firstproject.services.impl;

import java.util.List;
import java.util.Optional;

import com.demo.firstproject.exception.CandidateNotFound;
import com.demo.firstproject.models.CandidateModel;
import com.demo.firstproject.models.dto.CandidateDto;
import com.demo.firstproject.repository.CandidateRepository;
import com.demo.firstproject.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<CandidateModel>getCandidate() {
        return  candidateRepository.findAll();
    }


    public void createCandidate(CandidateDto candidateDto){
        CandidateModel candidate = CandidateModel
                .builder()
                .name(candidateDto.getName())
                .lastName(candidateDto.getLastName())
                .typeDni(candidateDto.getTypeDni())
                .documentNumber(candidateDto.getDocumentNumber())
                .dateOfBirth(candidateDto.getDateOfBirth())
                .build();
        candidateRepository.save(candidate);
    }

    public void updateCandidate(Long id, CandidateDto candidateDto){
        Optional<CandidateModel> result = candidateRepository.findById(id);
        if(result.isPresent()){
            result.get().setName(candidateDto.getName());
            result.get().setLastName(candidateDto.getLastName());
            result.get().setTypeDni(candidateDto.getTypeDni());
            result.get().setDocumentNumber(candidateDto.getDocumentNumber());
            result.get().setDateOfBirth(candidateDto.getDateOfBirth());
         candidateRepository.save(result.get());
        }
        else {
            throw new CandidateNotFound("El id" + id + "no existe");
        }
    }

    public void deleteCandidate (Long id){

        Optional<CandidateModel> result = candidateRepository.findById(id);
        if(result.isPresent()){
            candidateRepository.delete(result.get());
        }
        else {
            throw new CandidateNotFound("El id" + id + "no existe");
        }
    }


    public CandidateDto findCandidateDto (Long id){
        CandidateModel candidateModel = candidateRepository.getById(id);
        return  CandidateDto.builder()
                .name(candidateModel.getName())
                .lastName(candidateModel.getLastName())
                .build();

    }
}
