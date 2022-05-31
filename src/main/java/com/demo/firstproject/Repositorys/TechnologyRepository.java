package com.demo.firstproject.Repositorys;

import com.demo.firstproject.Model.TechnologyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<TechnologyModel,Long> {

}
