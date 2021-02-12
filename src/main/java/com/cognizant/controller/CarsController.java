package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cognizant.service.CarsService;

@RestController
@RequestMapping(value = "/api/cars")
public class CarsController {
	
	@Value("${WAREHOUSE_API}")
	private String warehouseAPI;

	private final CarsService carsService;
	private final RestTemplate restTemplate;
	
	public CarsController(CarsService carsService, RestTemplate restTemplate) {
		this.carsService = carsService;
		this.restTemplate = restTemplate;
	}

	@GetMapping
	public String getAllWareHouse() {
		return carsService.getWarehouseDetails();
	}
	
	@GetMapping("/health")
	public String getHealth() {
		String url = UriComponentsBuilder.fromHttpUrl(warehouseAPI).build().toUriString();
		return restTemplate.getForObject(url, String.class);
	}
}
