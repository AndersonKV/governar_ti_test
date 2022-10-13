package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
}
