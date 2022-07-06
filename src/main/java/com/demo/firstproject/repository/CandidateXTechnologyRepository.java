package com.demo.firstproject.repository;

import com.demo.firstproject.models.CandidateXTechnology;
import com.demo.firstproject.models.dto.CandidateXTechnologyDtoSend;
import com.demo.firstproject.projections.ListCandidatesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.demo.firstproject.querys.Querys.GET_LIST_CANDIDATES_X_TECHNOLOGY;

@Repository
public interface CandidateXTechnologyRepository extends JpaRepository<CandidateXTechnology,Long> {


    CandidateXTechnology findByCandidateId(Long id);

    @Query (value = GET_LIST_CANDIDATES_X_TECHNOLOGY ,nativeQuery = true)
    List<ListCandidatesProjection> listCandidatesXTechnology(String technology);
}
