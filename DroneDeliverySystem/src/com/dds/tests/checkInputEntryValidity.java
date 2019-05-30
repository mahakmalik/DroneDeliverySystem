package com.dds.tests;

import static org.junit.Assert.assertEquals;

import com.dds.appcode.OrderFileProcessor;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class checkInputEntryValidity {
	OrderFileProcessor op = new OrderFileProcessor();
	
	@When("^Input file contains corrupted data$")
	public void Input_File_contains_corrupted_data() {
		
		String[] array = {"WM003" ,",", "kshdu","jhjb"};		
		assertEquals(op.checkTheValidityOfTheEntry(array),false);
		
	}
		
	@When("^check if invalid orders get processed$")
	public void a_valid_input_file_with_invalid_entries() throws Throwable {	
		
		String[] array = {"WM003" , "kshdu"};		
		assertEquals(op.checkTheValidityOfTheEntry(array),false);		 
	}

	@Then("^The method should return false$")
	public void the_generated_order_list_should_not_have_invalid_entries() throws Throwable {
	  
	}
		
	@When("^the orderplacetime is after store close hours$")
	public void when_orderplaceTime_is_after_store_close_hours() throws Throwable {	
		String[] array = {"WM003" , "N7E3" ,"23:00:00"};
		assertEquals(op.checkTheValidityOfTheEntry(array),false);		 
	}
	
	
}
