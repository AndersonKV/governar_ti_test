package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.LapTimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LapTimesRepository extends JpaRepository<LapTimes, Long> {
}
