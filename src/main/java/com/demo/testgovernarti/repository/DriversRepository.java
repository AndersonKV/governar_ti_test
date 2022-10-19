package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriversRepository extends JpaRepository<Drivers, Long> {


    @Query(value = "SELECT Distinct(d.nationality) FROM Drivers d")
    String[] findByNationality();

    @Query("select count(d) from Drivers d where d.nationality = ?1")
    Integer countNationality(String n);
}
