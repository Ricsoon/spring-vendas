package com.hvendas.sistemavendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.hvendas.sistemavendas.entities"})
@EnableJpaRepositories(basePackages = {"com.hvendas.sistemavendas.repository"})
@ComponentScan(basePackages = {"com.hvendas.sistemavendas.service", "com.hvendas.sistemavendas.controller"})
@SpringBootApplication
public class SistemaVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaVendasApplication.class, args);

	}

}
