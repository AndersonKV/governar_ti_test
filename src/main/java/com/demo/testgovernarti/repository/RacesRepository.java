package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Races;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacesRepository extends JpaRepository<Races, Long> {
}
