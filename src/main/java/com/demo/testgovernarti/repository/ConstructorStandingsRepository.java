package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.ConstructorStandings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorStandingsRepository extends JpaRepository<ConstructorStandings, Long> {

}
