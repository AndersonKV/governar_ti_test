package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.DriverStandings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverStandingsRepository extends JpaRepository<DriverStandings, Long> {
}
