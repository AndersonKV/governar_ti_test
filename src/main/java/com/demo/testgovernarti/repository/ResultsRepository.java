package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Results;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
    @Query(value = "SELECT * FROM results WHERE driver_id = ?1", nativeQuery = true)
    List<Results> findByDriverId(Long id);


    @Query(value = "SELECT Distinct(results.constructorId) FROM Results results WHERE results.driverId = ?1")
    Long[] findConstructorsIdAndDriverId(Long id);
}
