package com.demo.testgovernarti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class TestEntity {
	@Id
	private Long id;

}
@Repository
interface Tanto extends JpaRepository<TestEntity, Long> {

}

@RestController
@RequestMapping(name = "test")
class TestController {
	@PostMapping
	public String test() {
		return "ok";
	}
}

@SpringBootApplication
public class TestDaGovernarTiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDaGovernarTiApplication.class, args);
	}

}
