package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.SprintResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintResultsRepository extends JpaRepository<SprintResults, Long> {
}
