package com.dds.tests;
import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Rule;

import com.dds.appcode.OrderFileProcessor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidateCreateOrderList {
	@Rule
	OrderFileProcessor op = new OrderFileProcessor();

	@Given("^System source code is available$")
	public void a_system_is_source_code_is_available() throws Throwable {
		System.out.println("Test Started");
	}
	
	@When("Order details are given to order process method")
	public void inputOrderParameters() {
		op.createOrderList("WM001", "N11W5", LocalTime.parse("06:00:00"));
	}

	@Then("^Order list should be created$")
	public void order_list_should_be_created() throws Throwable {		
		assertEquals(op.getCustOrderDetails().size(), 1);

	}
	
	

	
	
}
