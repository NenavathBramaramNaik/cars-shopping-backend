package com.cognizant.integration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WarehouseAPIIntegration {
	
	@Value("${WAREHOUSE_API}")
	private String warehouseAPI;

	private final RestTemplate restTemplate;

	public WarehouseAPIIntegration(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String wareHouseAPIDetails() {
		return getProxyWarehouseDetails();
	}
	
	//private String getWarehouseDetails() {
		//String url = UriComponentsBuilder.fromHttpUrl(warehouseAPI).build().toUriString();
		//return restTemplate.getForObject(url, String.class);
		//return getProxyWarehouseDetails();
	//}

	private String getProxyWarehouseDetails() {
		String rsJson = "";
		File file;
		try {
			file = ResourceUtils.getFile("classpath:warehouses.json");
			rsJson = new String(Files.readAllBytes(file.toPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("================================");
		System.out.println(rsJson);
		return rsJson;
	}
}
