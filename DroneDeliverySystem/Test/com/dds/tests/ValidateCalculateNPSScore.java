package com.dds.tests;

import java.time.LocalTime;

import org.junit.Assert;


import com.dds.appcode.CalculateNPSScore;
import com.dds.appcode.OrderDetails;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidateCalculateNPSScore {

	OrderDetails order=new OrderDetails("WM001" , "N7E3" , LocalTime.parse("10:00:00"));
	public LocalTime dispatchTime;
		
	@Before
	public static void resetStaticVariables() {
		CalculateNPSScore.promotors=0;
		CalculateNPSScore.totalProcessedOrders=0;
		CalculateNPSScore.detractors=0;
	}
	
	@When("^Order details and dispatch time are passed$")
	public void orderdetails_and_dispatchtime_is_provided_delivery_method() {
		dispatchTime=LocalTime.parse("10:00:00");
		CalculateNPSScore.calculateNPS(order, LocalTime.parse("10:30:00"), dispatchTime);	
		CalculateNPSScore.calculateNPS(order, LocalTime.parse("14:00:00"), dispatchTime);
	}
	
	@Then("^The promoter should be incremented according to time elapsed$")
	public void validate_calculated_promoters() {
	    Assert.assertEquals(1,CalculateNPSScore.promotors);		
	}
	
	@Then("^Or the detractor should be incremented according to time elapsed$")
	public void validate_calculated_detractors() {
		Assert.assertEquals(1,CalculateNPSScore.detractors);		
	}
	
	@And("^Total processedorder should be incremented$")
	public void validate_calculated_totalprocessedorder() {
		Assert.assertEquals(2,CalculateNPSScore.totalProcessedOrders);		
	}
	
}
