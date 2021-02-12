package com.cognizant.service.impl;

import org.springframework.stereotype.Service;

import com.cognizant.integration.WarehouseAPIIntegration;
import com.cognizant.service.CarsService;

@Service
public class CarsServiceImpl implements CarsService {

	private final WarehouseAPIIntegration warehouseAPIIntegration;
	
	public CarsServiceImpl(WarehouseAPIIntegration warehouseAPIIntegration) {
		this.warehouseAPIIntegration = warehouseAPIIntegration;
	}

	@Override
	public String getWarehouseDetails() {
		return warehouseAPIIntegration.wareHouseAPIDetails();
	}

}
