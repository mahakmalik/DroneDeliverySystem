package com.dds.appcode;
import java.time.LocalTime;

/** this class will create object for each row present in the input file**/
public class OrderDetails {

	private String orderId;
	private double roundTripTime;
	private LocalTime orderPlaceTime;

	public OrderDetails(String orderId, String location, LocalTime orderPlaceTime) {

		TripTimeCalculator cal = new TripTimeCalculator();
		this.setRoundTripTime(cal.calculateTotalTime(location));
		this.setOrderId(orderId);
		this.setOrderPlaceTime(orderPlaceTime);

	}

	public double getRoundTripTime() {
		return roundTripTime;
	}

	public void setRoundTripTime(double transportTime) {
		this.roundTripTime = transportTime;
	}

	public LocalTime getOrderPlaceTime() {
		return orderPlaceTime;
	}

	public void setOrderPlaceTime(LocalTime orderPlaceTime) {
		this.orderPlaceTime = orderPlaceTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
