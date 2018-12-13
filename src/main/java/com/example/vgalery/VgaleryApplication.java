package com.example.vgalery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
@RestController
public class VgaleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(VgaleryApplication.class, args);
	}

	@GetMapping("/_status")
	public String getStatus() {
		return "Ok";
	}
}
