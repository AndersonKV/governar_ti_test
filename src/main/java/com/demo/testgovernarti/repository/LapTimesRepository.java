package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.LapTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapTimesRepository extends JpaRepository<LapTimes, Long> {
}
