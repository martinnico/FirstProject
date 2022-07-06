package com.demo.firstproject.services;
import com.demo.firstproject.models.Candidate;
import com.demo.firstproject.models.dto.CandidateDto;


import java.util.List;

public interface CandidateService {

     List<Candidate> getCandidate();

     void createCandidate(CandidateDto candidateDto);

     void updateCandidate(Long id, CandidateDto candidate);

     void deleteCandidate (Long id);

     CandidateDto findCandidateDto (Long id);


}