package com.stackthreads.ws.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackthreads.ws.beans.ServiceStatus;

@RestController
public class ServiceStatusController {

	@GetMapping( path="/service-status")
	public String helloWorld() {
		return "Test Success! Service is up and running!";
	}
	
	@GetMapping( path="/service-status-dtl")
	public ServiceStatus helloWorldBean() {
		return new ServiceStatus();
	}
}
