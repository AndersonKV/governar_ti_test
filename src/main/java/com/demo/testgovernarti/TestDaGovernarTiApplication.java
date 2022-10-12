package com.demo.testgovernarti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;

@EnableAutoConfiguration
@SpringBootApplication
@EntityScan
public class TestDaGovernarTiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDaGovernarTiApplication.class, args);
	}

}


