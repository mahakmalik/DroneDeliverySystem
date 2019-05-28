package com.dds.tests;
import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.dds.appcode.OrderFileProcessor;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;

public class TS_DDS_01 {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	OrderFileProcessor op = new OrderFileProcessor();

	@Given("^A system is source code is available$")
	public void a_system_is_source_code_is_available() throws Throwable {
		System.out.println("Test Started");
	}

	
	@When("Order details are given to order process method")
	public void inputOrderParameters() {
		op.createOrderList("WM001", "N11W5", LocalTime.parse("06:00:00"));
		assertEquals(op.getCustOrderDetails().size(), 1);
		assertEquals(op.getSortedTripOrderDetails().get(0).getOrderId(), "WM001");
	}

	@Then("^Order list should be created$")
	public void order_list_should_be_created() throws Throwable {
		assertEquals(op.getCustOrderDetails().size(), 1);
		assertEquals(op.getSortedTripOrderDetails().get(0).getOrderId(), "WM001");

	}
   
	@Given("^A invalid input file path$")
	@Test
	public void a_invalid_input_file_path(DataTable data) throws Throwable {
		List<String> filepath = data.asList(String.class);
		op.bufferedReaderToArrayList(filepath.get(0));
		op.bufferedReaderToArrayList(filepath.get(1));
		thrown.expect(IOException.class);		
	}
		
	@Then("^A error should pop$")
	public void a_error_should_pop() throws Throwable {
	  		
	}
	
	@Given("^A valid input file path$")
	@Test
	public void a_valid_input_file_path(DataTable data) throws Throwable {
		List<String> filepath = data.asList(String.class);
		op.bufferedReaderToArrayList(filepath.get(0));
		thrown.expect(IOException.class);		
	}
	
	@Then("^orderlist should be created$")
	public void order_should_pop() throws Throwable {
		assertEquals(op.getSortedTripOrderDetails().get(0).getOrderId(), "WM002");
	}
	
	
}
