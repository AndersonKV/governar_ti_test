package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonsRepository extends JpaRepository<Seasons, Long> {
}
