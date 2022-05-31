package com.demo.firstproject.Repositorys;

import com.demo.firstproject.Model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateModel,Long> {

}
