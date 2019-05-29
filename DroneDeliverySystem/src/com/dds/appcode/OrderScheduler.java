package com.dds.appcode;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import com.dds.exceptions.ListEmptyException;

/**
 * OrderScheduler.java - The purpose of this class is to schedule orders for
 * delivery
 * 
 * @author Mahak Malik
 *
 */
public class OrderScheduler {

	private LocalTime deliveryTime;
	private LocalTime returnTime;
	private LocalTime currDispatchTime = MainClass.OPEN_STORE_TIME;
	private LocalTime storeCloseTime = MainClass.CLOSE_STORE_TIME;

	/**
	 * Select order processing order based on the set assumptions (Store open and
	 * close time in this case)
	 * 
	 * @param sortedTripOrderDetails - List that contains orders sorted by
	 *                               round-trip time.
	 * @param custOrderDetails       - List that contains all orders as it is.
	 * @throws ListEmptyException - If any List is empty.
	 */
	public void orderSelection(ArrayList<OrderDetails> sortedTripOrderDetails, ArrayList<OrderDetails> custOrderDetails)
			throws ListEmptyException {

		while (!sortedTripOrderDetails.isEmpty()) {
			Iterator<OrderDetails> iterator = sortedTripOrderDetails.iterator();
			while (iterator.hasNext()) {
				OrderDetails order = this.selectNextOrder(sortedTripOrderDetails, custOrderDetails);

				if (order != null) {
					if (order.getOrderPlaceTime().isAfter(this.currDispatchTime)) {
						this.setCurrDispatchTime(order.getOrderPlaceTime());
					}
					// add 1 minute to the dispatch time according to the assumption that it
					// takes 1 minute to load the drone
					this.setCurrDispatchTime(this.getCurrDispatchTime().plusMinutes(1));
					this.setDeliveryTime(this.getDeliveryTime(order, this.getCurrDispatchTime()));

					// when the drone comes back to the base;
					this.setReturnTime(this.getReturnTime(order, this.getCurrDispatchTime()));
					if (this.getReturnTime().isAfter(storeCloseTime)) {
						sortedTripOrderDetails.remove(order);
						custOrderDetails.remove(order);

					} else {

						// calculate the NPS score
						CalculateNPSScore.calculateNPS(order, this.deliveryTime, this.getCurrDispatchTime());

						// return time for previous order will be dispatch time for next order
						this.setCurrDispatchTime(this.getReturnTime());

						// remove selected orders till list empty
						sortedTripOrderDetails.remove(order);
						custOrderDetails.remove(order);
					}
				}
			}

		}
	}

	/**
	 * Retrieve/Select next order to be processed that will maximize NPS
	 * @param sortedTripOrderDetails - List with orders sorted by roundTripTime
	 * @param custOrderDetails - List with all orders as it is.
	 * @return OrderDetails object representing the next order to be processed.
	 * @throws ListEmptyException - If any of the list of empty.
	 * @see OrderDetails
	 */
	public OrderDetails selectNextOrder(ArrayList<OrderDetails> sortedTripOrderDetails,
			ArrayList<OrderDetails> custOrderDetails) throws ListEmptyException {
		
		OrderDetails order = sortedTripOrderDetails.stream()
				.filter(o -> this.currDispatchTime.isAfter(o.getOrderPlaceTime())
						|| currDispatchTime.equals(o.getOrderPlaceTime()))
				.findAny().orElse(null);

		// get order with the earliest/least order place time if no orders found
		if (order == null && !custOrderDetails.isEmpty()) {
			order = custOrderDetails.get(0);
		}
		return order;
	}
	
	/**
	 * Set value of deliveryTime.
	 * @param deliveryTime - LocalTime object with value of deliveryTime.
	 */
	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	/**
	 * Calculate and Retrieve value of deliveryTime.
	 * @param order - OrderDetails object representing customer order.
	 * @param currDispatchTime - LocalTime object with earliest possible dispatch time.
	 * @return LocalTime object representing the time of delivery.
	 */
	public LocalTime getDeliveryTime(OrderDetails order, LocalTime currDispatchTime) {
		int minutes = (int) (order.getRoundTripTime() / 2);
		deliveryTime = currDispatchTime.plusMinutes(minutes);
		return deliveryTime;
	}

	/**
	 * Calculate and Retrieve value of returnTime, i.e., the time of drone return.
	 * @param order - OrderDetails object representing customer order.
	 * @param currDispatchTime - Earliest possible dispatch time.
	 * @return LocalTime object representing time of drone return.
	 */
	public LocalTime getReturnTime(OrderDetails order, LocalTime currDispatchTime) {
		int minutes = (int) (order.getRoundTripTime());
		returnTime = currDispatchTime.plusMinutes(minutes);
		return returnTime;
	}
	
	/**
	 * Retrieve value of currdispatchTime.
	 * @return LocalTime object with earliest possible drone dispatch time.
	 */
	public LocalTime getCurrDispatchTime() {
		return currDispatchTime;
	}
	
	/**
	 * Set the value of currDispatchTime
	 * @param currDispatchTime - Earliest possible dispatch time.
	 */
	public void setCurrDispatchTime(LocalTime currDispatchTime) {
		this.currDispatchTime = currDispatchTime;
	}
	
	/**
	 * Retrieve value of returnTime.
	 * @return LocalTime object with value of drone return time after completing delivery.
	 */
	public LocalTime getReturnTime() {
		return returnTime;
	}
	
	/**
	 * Set the value of returnTime
	 * @param returnTime - LocalTime object with value of drone return time after completing delivery.
	 */
	public void setReturnTime(LocalTime returnTime) {
		this.returnTime = returnTime;
	}

}