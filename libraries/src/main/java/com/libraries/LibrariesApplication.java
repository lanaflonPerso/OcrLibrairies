package com.libraries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LibrariesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrariesApplication.class, args);
	}

}
