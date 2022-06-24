package com.demo.firstproject.repository;

import com.demo.firstproject.models.TechnologyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<TechnologyModel,Long> {

}
