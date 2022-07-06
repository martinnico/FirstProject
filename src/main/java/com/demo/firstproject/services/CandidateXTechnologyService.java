package com.demo.firstproject.services;

import com.demo.firstproject.models.CandidateXTechnology;
import com.demo.firstproject.models.dto.CandidateXTechnologyDto;

import java.util.List;

public interface CandidateXTechnologyService {

     List<CandidateXTechnology> getCandidateXTechnology();

     void createCandidateXTechnology(CandidateXTechnologyDto candidateXTechnologyDtoSend);

     void updateCandidateXTechnology(Long id, CandidateXTechnologyDto candidateXTechnologyDtoSend);

     void deleteCandidateXTechnology (Long id);

     CandidateXTechnologyDto findCandidateXTechnologyDto(Long candidateId);
}
