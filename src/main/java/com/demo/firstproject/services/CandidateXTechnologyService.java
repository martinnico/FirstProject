package com.demo.firstproject.services;

import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.models.dto.CandidateXTEchnologyDto;

import java.util.List;

public interface CandidateXTechnologyService {

     List<CandidateXTechnologyModel> getCandidateXTechnology();

     CandidateXTechnologyModel createCandidateXTechnology(CandidateXTechnologyModel candidateXTechnology);

     CandidateXTechnologyModel updateCandidateXTechnology(Long id, CandidateXTechnologyModel candidateXTechnology);

     void deleteCandidateXTechnology (Long id);

     CandidateXTEchnologyDto findCandidateXTechnologyDto(Long candidateId);
}
