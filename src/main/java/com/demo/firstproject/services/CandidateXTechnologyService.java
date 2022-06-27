package com.demo.firstproject.services;

import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.models.dto.CandidateXTEchnologyDto;
import com.demo.firstproject.models.dto.CandidateXTechnologyDtoSend;

import java.util.List;

public interface CandidateXTechnologyService {

     List<CandidateXTechnologyModel> getCandidateXTechnology();

     CandidateXTechnologyModel createCandidateXTechnology(CandidateXTechnologyDtoSend candidateXTechnologyDtoSend);

     CandidateXTechnologyModel updateCandidateXTechnology(Long id, CandidateXTechnologyDtoSend candidateXTechnologyDtoSend);

     void deleteCandidateXTechnology (Long id);

     CandidateXTEchnologyDto findCandidateXTechnologyDto(Long candidateId);
}
