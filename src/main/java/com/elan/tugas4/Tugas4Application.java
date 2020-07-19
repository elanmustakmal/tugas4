package com.elan.tugas4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Tugas4Application {

	public static void main(String[] args) {
		SpringApplication.run(Tugas4Application.class, args);
	}

}
