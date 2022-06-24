package com.demo.firstproject.repository;

import com.demo.firstproject.models.CandidateXTechnologyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateXTechnologyRepository extends JpaRepository<CandidateXTechnologyModel,Long> {
    CandidateXTechnologyModel findByCandidateId(Long id);
}
