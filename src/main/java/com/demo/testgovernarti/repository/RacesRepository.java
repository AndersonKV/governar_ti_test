package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Races;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RacesRepository extends JpaRepository<Races, Long> {
    Optional<Races> findByYearsAndRound(String year, Integer rounds);
   // Optional<Races> find(String year, Integer rounds);
}
