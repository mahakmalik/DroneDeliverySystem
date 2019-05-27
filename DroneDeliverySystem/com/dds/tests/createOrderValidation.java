package com.dds.tests;
import com.dds.appcode.*;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;


import cucumber.api.java.en.*;

public class createOrderValidation {
@Test
	@When("when order details are given to order process method")
	 public void inputOrderParameters() {
		 OrderFileProcessor op = new OrderFileProcessor();
	      op.createOrderList("WM001" , "N11W5" , LocalTime.parse("06:00:00") );	      
	      assertEquals(op.getCustOrderDetails().size(), 1);
	      assertEquals(op.getSortedTripOrderDetails().get(0).getOrderId(), "WM001"); 
		 
		 
	 }
}
