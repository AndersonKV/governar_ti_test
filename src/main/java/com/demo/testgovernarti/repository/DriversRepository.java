package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriversRepository extends JpaRepository<Drivers, Long> {
    @Query(value = "SELECT Distinct(d.nationality), d.id FROM Drivers d")
    List findByNationality();
}
