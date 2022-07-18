package com.demo.firstproject.services.impl;

import com.demo.firstproject.exception.CandidateNotFoundException;
import com.demo.firstproject.models.Candidate;
import com.demo.firstproject.models.dto.CandidateDto;
import com.demo.firstproject.repository.CandidateRepository;
import com.demo.firstproject.services.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getCandidate() {
        return candidateRepository.findAll();
    }


    @Override
    public void createCandidate(CandidateDto candidateDto) {
        Candidate candidate = Candidate
                .builder()
                .name(candidateDto.getName())
                .lastName(candidateDto.getLastName())
                .typeDni(candidateDto.getTypeDni())
                .documentNumber(candidateDto.getDocumentNumber())
                .dateOfBirth(candidateDto.getDateOfBirth())
                .build();
        candidateRepository.save(candidate);
        log.debug("Se creo un nuevo candidato: " + candidate);
    }

    @Override
    public void updateCandidate(Long id, CandidateDto candidateDto) {
        Candidate result = candidateRepository.findById(id).orElseThrow(() ->
                new CandidateNotFoundException("Candidato no encontrado "));
        try {
            if (result != null) {
                result = Candidate.builder()
                        .name(candidateDto.getName())
                        .lastName(candidateDto.getLastName())
                        .typeDni(candidateDto.getTypeDni())
                        .documentNumber(candidateDto.getDocumentNumber())
                        .dateOfBirth(candidateDto.getDateOfBirth())
                        .build();
                candidateRepository.save(result);
                log.debug("Se actualizo el candidato: " + result);
            }
        } catch (CandidateNotFoundException c) {
            log.error("El candidato no se ha encontrado: ", c);
        }
    }

    @Override
    public void deleteCandidate(Long id) {

        Optional<Candidate> result = candidateRepository.findById(id);
        try {
            if (result.isPresent()) {
                candidateRepository.delete(result.get());
                log.debug("Se elimino el candidato: " + result);
            }
        } catch (CandidateNotFoundException e) {
            log.error("El Candidato con el ID seleccionado no existe: ", e);

        }
    }


    @Override
    public CandidateDto findCandidateDto(Long id) {
        Candidate candidate = candidateRepository.getById(id);
        try {
            log.debug("Se retorna el candidato: " + candidate);
            return CandidateDto.builder()
                    .name(candidate.getName())
                    .lastName(candidate.getLastName())
                    .build();
        } catch (CandidateNotFoundException c) {
            log.error("Candidato no encontrado", c);
        }
        return null;
    }

}
