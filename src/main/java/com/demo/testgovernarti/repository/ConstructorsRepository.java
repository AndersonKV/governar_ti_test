package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Constructors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorsRepository extends JpaRepository<Constructors, Long> {
}
