package com.demo.firstproject.services.impl;

import com.demo.firstproject.exception.CandidateXTechnologyNotFoundException;
import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.models.dto.CandidateXTechnologyDto;
import com.demo.firstproject.projections.ListCandidates;
import com.demo.firstproject.repository.CandidateXTechnologyRepository;
import com.demo.firstproject.services.CandidateXTechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CandidateXTechnologyServiceImp implements CandidateXTechnologyService {
    @Autowired
    private CandidateXTechnologyRepository candidateXTechnologyRepository;

    public List<CandidateXTechnologyModel> getCandidateXTechnology() {
        return candidateXTechnologyRepository.findAll();
    }

    @Override
    public void createCandidateXTechnology(CandidateXTechnologyDto candidateXTechnologySendDto) {
        CandidateXTechnologyModel candidateXTechnologyModel = CandidateXTechnologyModel
                .builder()
                .candidate(candidateXTechnologySendDto.getCandidate())
                .technologyModel(candidateXTechnologySendDto.getTechnology())
                .experience(candidateXTechnologySendDto.getExperience())
                .build();
        candidateXTechnologyRepository.save(candidateXTechnologyModel);
        log.debug("Se agrego el objeto: " + candidateXTechnologyModel);
    }

    @Override
    public void updateCandidateXTechnology(Long id, CandidateXTechnologyDto candidateXTechnologySendDto) {
        CandidateXTechnologyModel result = candidateXTechnologyRepository.findById(id).orElseThrow(() -> new CandidateXTechnologyNotFoundException("Objeto no encontrado "));
        try {
            if (result != null) {
                result = CandidateXTechnologyModel.builder()
                        .candidate(candidateXTechnologySendDto.getCandidate())
                        .technologyModel(candidateXTechnologySendDto.getTechnology())
                        .experience(candidateXTechnologySendDto.getExperience())
                        .build();
                candidateXTechnologyRepository.save(result);
            }
        } catch (CandidateXTechnologyNotFoundException c) {
            log.error("El objeto con ID: " + id + " no se ha encontrado");
        }
    }

    @Override
    public void deleteCandidateXTechnology(Long id) {


        Optional<CandidateXTechnologyModel> result = candidateXTechnologyRepository.findById(id);
        try {
            if (result.isPresent()) {
                candidateXTechnologyRepository.delete(result.get());
            }
        } catch (CandidateXTechnologyNotFoundException c) {
            log.error("El objeto con ID: " + id + " no se ha encontrado");
        }
    }



    @Override
    public CandidateXTechnologyDto findCandidateXTechnologyDto(Long candidateId) {
        CandidateXTechnologyModel candidateXTechnology = candidateXTechnologyRepository.findByCandidateId(candidateId);
            return CandidateXTechnologyDto.builder()
                    .candidate(candidateXTechnology.getCandidate())
                    .technology(candidateXTechnology.getTechnologyModel())
                    .experience(candidateXTechnology.getExperience())
                    .build();
        }

    public List<ListCandidates> listCandidatesXTechnologies(String technology) {
        return candidateXTechnologyRepository.listCandidatesXTechnology(technology);
    }
}
