package com.dds.tests;

import java.time.LocalTime;
import java.util.List;

import com.dds.appcode.CalculateNPSScore;
import com.dds.appcode.OrderDetails;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class TS_DDS_03 {
	
	OrderDetails order = new OrderDetails("WM001" , "N7E4" , LocalTime.parse(""));
	CalculateNPSScore nps = new CalculateNPSScore();
	
	@Given("^<order details>, <current dispatch time> and <orderdeliverytime> are passed$")
	public void mock_LocalTime_parse_and_orderdeliverytime_are_passed(DataTable data) throws Throwable {
	    List<String> arr = data.asList(String.class);
	    LocalTime deliveryTime= LocalTime.parse(arr.get(1));
	    LocalTime currDispatchTime= LocalTime.parse(arr.get(2));
		
		nps.calculateNPS(order,deliveryTime,currDispatchTime );		
	}
	
	@Then("^The timeelpased should calculate the correct time diferrence$")
	public void the_timeelpased_should_calculate_the_correct_time_diferrence() throws Throwable {
		System.out.println(nps.getPromotors());
	}
	
	@When("^time elpased is less than (\\d+) min$")
	public void time_elpased_is_less_than_min(int arg1) throws Throwable {
	    
	}
	
	@Then("^promoter should be incremented$")
	public void promoter_should_be_incremented() throws Throwable {
	   
	}

	@When("^time elpased is greater than (\\d+) min$")
	public void time_elpased_is_greater_than_min(int arg1) throws Throwable {
	   
	}

	@Then("^detractor should get incremented$")
	public void detractor_should_get_incremented() throws Throwable {
	   
	}

}
