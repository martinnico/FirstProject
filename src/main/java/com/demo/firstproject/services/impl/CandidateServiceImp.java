
package com.demo.firstproject.services.impl;

import java.util.List;
import java.util.Optional;

import com.demo.firstproject.exception.CandidateNotFoundException;
import com.demo.firstproject.models.CandidateModel;
import com.demo.firstproject.models.dto.CandidateDto;
import com.demo.firstproject.repository.CandidateRepository;
import com.demo.firstproject.services.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<CandidateModel>getCandidate() {
        return  candidateRepository.findAll();
    }

    @Override
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

    @Override
    public void updateCandidate(Long id, CandidateDto candidateDto){
        CandidateModel result = candidateRepository.findById(id).orElseThrow(()->new CandidateNotFoundException("Candidato no encontrado "));
        try {
        if( result!= null ){
              result = CandidateModel.builder()
                      .name(candidateDto.getName())
                      .lastName(candidateDto.getLastName())
                      .typeDni(candidateDto.getTypeDni())
                      .documentNumber(candidateDto.getDocumentNumber())
                      .dateOfBirth(candidateDto.getDateOfBirth())
                      .build();
              candidateRepository.save(result);
          } }catch (CandidateNotFoundException c){
                log.error("El candidato con ID: "+id+" no se ha encontrado");
          }
    }
    @Override
    public void deleteCandidate (Long id){

        Optional<CandidateModel> result = candidateRepository.findById(id);
        try{
            result.isPresent();
                candidateRepository.delete(result.get());
            }catch(CandidateNotFoundException e){
                log.error("El Candidato con id: " + id + "no se ha encontrado");

            }
        }


    @Override
    public CandidateDto findCandidateDto (Long id){
        CandidateModel candidateModel = candidateRepository.getById(id);
        return  CandidateDto.builder()
                .name(candidateModel.getName())
                .lastName(candidateModel.getLastName())
                .build();

    }
}
