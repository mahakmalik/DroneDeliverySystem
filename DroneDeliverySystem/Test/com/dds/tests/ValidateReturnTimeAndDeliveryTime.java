package com.dds.tests;

import java.time.LocalTime;

import org.junit.Assert;

import com.dds.appcode.OrderDetails;
import com.dds.appcode.OrderScheduler;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidateReturnTimeAndDeliveryTime {

	OrderDetails order=new OrderDetails("WM001" , "N7E3" , LocalTime.parse("10:00:00"));
	OrderScheduler os=new OrderScheduler();
	public LocalTime deliverytime,returnTime;
	
	@When("^Orderdetails and curr dispatch time is provided to deliverytime method$")
	public void orderdetails_and_dispatchtime_is_provided_delivery_method() {
		
		this.deliverytime=os.getDeliveryTime(order,LocalTime.parse("11:00"));
		
	}
	
	@Then("^delivery time must be calculated$")
	public void validate_calculated_deliverytime() {
		
		Assert.assertTrue(LocalTime.parse("11:07:00").equals(this.deliverytime));
		
	}
	
	@When("^Orderdetails and curr dispatch time is provided to returntime method$")
	public void orderdetails_and_dispatchtime_is_provided_to_return_method() {
		
		this.returnTime=os.getReturnTime(order,LocalTime.parse("11:00"));
		
	}
	
	@Then("^return time must be calculated$")
	public void validate_calculated_returntime() {
		
		Assert.assertTrue(LocalTime.parse("11:15:00").equals(this.returnTime));
		
	}
	
}
