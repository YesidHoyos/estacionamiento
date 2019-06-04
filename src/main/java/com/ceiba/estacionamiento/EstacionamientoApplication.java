package com.ceiba.estacionamiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ceiba.estacionamiento.comando.*")
public class EstacionamientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamientoApplication.class, args);
	}

}
