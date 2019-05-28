package com.dds.tests;

import java.io.IOException;
import java.util.List;

import com.dds.appcode.OrderFileProcessor;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class TS_DDS_02 {
	
	OrderFileProcessor op = new OrderFileProcessor();
	
	@Given("^A valid input file with invalid entries$")
	public void a_valid_input_file_with_invalid_entries(DataTable data) throws Throwable {
		List<String> arr = data.asList(String.class);
		op.checkTheValidityOfTheEntry(arr);
		 
	}

	@Then("^The generated order list should not have invalid entries$")
	public void the_generated_order_list_should_not_have_invalid_entries() throws Throwable {
	  
	}
}
