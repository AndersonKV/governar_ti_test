package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.DriverStandings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;

@Repository
public interface DriverStandingsRepository extends JpaRepository<DriverStandings, Long> {
    List<DriverStandings> findByWins(Integer n);

    @Query(value = "SELECT * FROM driver_standings WHERE race_id = ?1", nativeQuery = true)
    List<DriverStandings> findByRaceId(Long id);
    //List<DriverStandings> findByWinsGreaterThanEqual(Integer n);
}
