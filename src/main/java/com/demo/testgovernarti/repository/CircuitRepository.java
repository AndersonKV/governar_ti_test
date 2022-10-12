package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Long> {
}
