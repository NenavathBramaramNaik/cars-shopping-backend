package com.cognizant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_getAllWarehouseDetails() throws Exception {
		File file = ResourceUtils.getFile("classpath:warehouses.json");
		String expectedJson = new String(Files.readAllBytes(file.toPath()));

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/cars"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print()).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		String actual = mvcResult.getResponse().getContentAsString();
		JSONAssert.assertEquals(expectedJson, actual, true);
	}

	@Test
	public void test_CatchExceptionIfWarehouseAPIisDown() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/health"))
				.andExpect(MockMvcResultMatchers.status().isForbidden()).andDo(print()).andReturn();
	}
}
