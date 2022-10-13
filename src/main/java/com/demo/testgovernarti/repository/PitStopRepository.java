package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.PitStops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitStopRepository extends JpaRepository<PitStops, Long> {
}
