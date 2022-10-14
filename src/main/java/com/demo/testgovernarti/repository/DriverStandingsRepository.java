package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.DriverStandings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;

@Repository
public interface DriverStandingsRepository extends JpaRepository<DriverStandings, Long> {
    @Query(value = "SELECT Distinct(d.driverId) FROM DriverStandings d WHERE d.wins = ?1")
    Long[] findByWins(Integer n);

    List<DriverStandings> findByRaceId(Long id);
}
