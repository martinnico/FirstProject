package com.demo.firstproject.repository;

import com.demo.firstproject.models.CandidateXTechnologyModel;
import com.demo.firstproject.models.dto.CandidateXTEchnologyDto;
import com.demo.firstproject.projections.Listcandidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.demo.firstproject.querys.Querys.GET_LIST_CANDIDATES_X_TECHNOLOGY;

@Repository
public interface CandidateXTechnologyRepository extends JpaRepository<CandidateXTechnologyModel,Long> {


    CandidateXTechnologyModel findByCandidateId(Long id);

    @Query (value = GET_LIST_CANDIDATES_X_TECHNOLOGY ,nativeQuery = true)
    List<Listcandidates> listCandidatesXTechnology(String technology);
}
