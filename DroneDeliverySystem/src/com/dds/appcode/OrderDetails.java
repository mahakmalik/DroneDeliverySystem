package com.dds.appcode;

import java.time.LocalTime;

/**
 * OrderDetails.java - This class represents the order present in the orders
 * input file as an object.
 * 
 * @author Mahak Malik
 *
 */
public class OrderDetails {

	private String orderID;
	private String deliveryLocation;
	private LocalTime orderPlaceTime;
	private double roundTripTime;

	public OrderDetails(String orderID, String deliveryLocation, LocalTime orderPlaceTime) {

		this.setOrderID(orderID);
		this.setDeliveryLocation(deliveryLocation);
		this.setOrderPlaceTime(orderPlaceTime);
		this.setRoundTripTime(this.getRoundTripTime());

	}

	/**
	 * Retrieve the value of orderID.
	 * 
	 * @return A string for orderID.
	 */
	public String getOrderID() {
		return this.orderID;
	}

	/**
	 * Set the value of order ID.
	 * 
	 * @param orderID - A String for orderID.
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	/**
	 * Retrieve the value of deliveryLocation
	 * 
	 * @return A String for deliverLocation.
	 */
	public String getDeliveryLocation() {
		return this.deliveryLocation;
	}

	/**
	 * Set the value of deliverLocation.
	 * 
	 * @param deliveryLocation - A string for deliveryLocation.
	 */
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	/**
	 * Retrieve value or orderPlaceTime.
	 * 
	 * @return A LocalTime object for orderPlaceTime.
	 */
	public LocalTime getOrderPlaceTime() {
		return this.orderPlaceTime;
	}

	/**
	 * Set the value of orderPlaceTime.
	 * 
	 * @param orderPlaceTime - A LocalTime Object for orderPlaceTime.
	 */
	public void setOrderPlaceTime(LocalTime orderPlaceTime) {
		this.orderPlaceTime = orderPlaceTime;
	}

	/**
	 * Retrieve round trip time from warehouse to delivery location
	 * 
	 * @return A Double representing minutes and seconds.
	 */
	public double getRoundTripTime() {
		String deliveryLocation = this.getDeliveryLocation();
		if (deliveryLocation != null) {
			String[] location = deliveryLocation.trim().split("[NWES]");

			double firstDir = Math.pow(Double.parseDouble(location[1]), 2);
			double secDir = Math.pow(Double.parseDouble(location[2]), 2);
			this.setRoundTripTime(Math.round((2 * Math.sqrt(firstDir + secDir)) * 100.0) / 100.0);
		}
		return roundTripTime;
	}

	/**
	 * Set the round trip time from warehouse to delivery location
	 * 
	 * @param roundTripTime - A Double representing roundTripTime.
	 */
	public void setRoundTripTime(double roundTripTime) {
		this.roundTripTime = roundTripTime;
	}

}
