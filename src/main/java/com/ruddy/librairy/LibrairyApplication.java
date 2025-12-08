package com.ruddy.librairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.ruddy.repository")
@EntityScan("com.ruddy.model") 
@ComponentScan(basePackages = {"com.ruddy.librairy", "com.ruddy.controller", "com.ruddy.service"})
public class LibrairyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrairyApplication.class, args);
	}

}
