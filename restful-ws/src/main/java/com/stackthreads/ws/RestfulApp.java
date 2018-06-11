package com.stackthreads.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Annotation required to tell spring, this is an starting point for web app.
 * @author nverma4
 */
@SpringBootApplication
public class RestfulApp {

	
	public static void main(String[] args) {
		SpringApplication.run(RestfulApp.class, args);
	}
}
