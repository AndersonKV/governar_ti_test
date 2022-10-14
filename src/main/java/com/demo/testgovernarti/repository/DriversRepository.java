package com.demo.testgovernarti.repository;

import com.demo.testgovernarti.entities.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriversRepository extends JpaRepository<Drivers, Long> {

}
