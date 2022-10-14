package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.ConstructorResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConstructorResultsRepository extends JpaRepository<ConstructorResults, Long> {
}
