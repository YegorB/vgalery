package com.example.vgalery;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class VgaleryApplication {


	@Bean
	public Datastore cloudDatastoreService() {
		return DatastoreOptions.getDefaultInstance().getService();
	}

	public static void main(String[] args) {
		SpringApplication.run(VgaleryApplication.class, args);
	}
}
