package com.dds.tests;

import java.time.LocalTime;

import com.dds.appcode.OrderDetails;
import com.dds.appcode.OrderScheduler;

public class ValidateCalculateNPSScore {

	OrderDetails order=new OrderDetails("WM001" , "N7E3" , LocalTime.parse("10:00:00"));
	OrderScheduler os=new OrderScheduler();
	public LocalTime deliverytime,returnTime;
	
	
	
}
