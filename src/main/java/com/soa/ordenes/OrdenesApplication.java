package com.soa.ordenes;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.soa.ordenes.domain.model")
@EnableJpaRepositories("com.soa.ordenes.infraestructure.persistence")
public class OrdenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdenesApplication.class, args);
	}

}
