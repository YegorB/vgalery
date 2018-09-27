package com.example.vgalery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VgaleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(VgaleryApplication.class, args);
	}
}
