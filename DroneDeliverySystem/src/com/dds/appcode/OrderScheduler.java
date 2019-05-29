package com.dds.appcode;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import com.dds.exceptions.ListEmptyException;

public class OrderScheduler {

	private static LocalTime dispatchTime;
	private LocalTime deliveryTime;
	private LocalTime returnTime;
<<<<<<< HEAD
	private ArrayList<OrderDetails> OrderDetails = new ArrayList<OrderDetails>();
	private ArrayList<OrderDetails> sortedDetails = new ArrayList<OrderDetails>();;
    private LocalTime storeCloseTime = MainClass.CLOSE_STORE_TIME;
	
=======
	private LocalTime currDispatchTime = MainClass.OPEN_STORE_TIME;
	//	private ArrayList<OrderDetails> OrderDetails = new ArrayList<OrderDetails>();
	//	private ArrayList<OrderDetails> sortedDetails = new ArrayList<OrderDetails>();;

>>>>>>> refs/remotes/origin/master
	// this constructor helps to make the sorted and cut order details data
	// available for processing
	//	OrderScheduler(ArrayList<OrderDetails> sortedTripOrderDetails, ArrayList<OrderDetails> custOrderDetails) {
	//
	//		this.sortedDetails.addAll(sortedTripOrderDetails);
	//
	//		this.OrderDetails.addAll(custOrderDetails);
	//
	//	}

	public void orderSelection(ArrayList<OrderDetails> sortedTripOrderDetails,
			ArrayList<OrderDetails> custOrderDetails) throws ListEmptyException{
		
		while(!sortedTripOrderDetails.isEmpty()) {
			Iterator<OrderDetails> iterator = sortedTripOrderDetails.iterator();
			while(iterator.hasNext()) {
				OrderDetails order = this.selectNextOrder(sortedTripOrderDetails, custOrderDetails);

				// the loop will run till all the orders present in the file are processed
				if (order != null) {
					if (order.getOrderPlaceTime().isAfter(this.currDispatchTime)) {
						this.currDispatchTime = order.getOrderPlaceTime();
					}
					// we will add 1 minute to the dispatch time according to the assumption that it
					// takes 1 minute for loading of drone
					this.currDispatchTime = this.currDispatchTime.plusMinutes(1);
					// calling the delivery function to get the time at which order was delivered to
					// the customer
					deliveryTime = this.getDeliveryTime(order, this.currDispatchTime);

					// when the drone comes back to the base;
					returnTime = this.getReturnTime(order, this.currDispatchTime);

					// calling method to calculate the NPS score
					CalculateNPSScore.calculateNPS(order, deliveryTime, this.currDispatchTime);

					// the return time for previous order will now be the dispatch time for the next
					// order
					this.currDispatchTime = returnTime;

					// we will remove the selected orders as the loop will run till the list is
					// empty
					sortedTripOrderDetails.remove(order);
					custOrderDetails.remove(order);
			}
<<<<<<< HEAD
			// we will add 1 minute to the dispatch time according to the assumption that it
			// takes 1 minute for loading of drone
			currDispatchTime = currDispatchTime.plusMinutes(1);
			// calling the delivery function to get the time at which order was delivered to
			// the customer
			deliveryTime = getDeliveryTime(order, currDispatchTime);

			// when the drone comes back to the base;
			
			returnTime = getDeliveryTime(order, currDispatchTime);

			if(returnTime.isAfter(storeCloseTime))
			{   
				sortedDetails.remove(order);
				OrderDetails.remove(order);
				
				
			}else {
				
			
			// calling method to calculate the NPS score
			CalculateNPSScore.calculateNPS(order, deliveryTime, currDispatchTime);

			// the return time for previous order will now be the dispatch time for the next
			// order
			currDispatchTime = returnTime;

			// we will remove the selected orders as the loop will run till the list is
			// empty
			sortedDetails.remove(order);
			OrderDetails.remove(order);

			order = selectNextOrder(currDispatchTime);
			}
=======
>>>>>>> refs/remotes/origin/master
		}
		// initially we call selectNextOrder with dispatch time = Store open time
		
			//order = this.selectNextOrder(sortedTripOrderDetails, custOrderDetails);
		}
	}

	// we are selecting the order that should be picked next.
	public OrderDetails selectNextOrder(ArrayList<OrderDetails> sortedTripOrderDetails,
			ArrayList<OrderDetails> custOrderDetails) throws ListEmptyException {
		// We will select the first order present in the sorted list according to the
		// currdispatch time
		OrderDetails order = sortedTripOrderDetails.stream()
				.filter(o -> this.currDispatchTime.isAfter(o.getOrderPlaceTime())
						|| currDispatchTime.equals(o.getOrderPlaceTime()))
				.findAny().orElse(null);

		// get the order with the earliest order place time if no orders were found
		if (order == null && !custOrderDetails.isEmpty()) {
			order = custOrderDetails.get(0);
		}
//		else {
//			continue;
//		}
		return order;
	}

	public LocalTime getDeliveryTime(OrderDetails Order, LocalTime currDispatchTime){
		int minutes = (int) (Order.getRoundTripTime() / 2);
		deliveryTime = currDispatchTime.plusMinutes(minutes);
		return deliveryTime;
	}

	public LocalTime getReturnTime(OrderDetails Order, LocalTime currDispatchTime){
		int minutes = (int) (Order.getRoundTripTime());
		returnTime = currDispatchTime.plusMinutes(minutes);
<<<<<<< HEAD
		
=======
>>>>>>> refs/remotes/origin/master
		return returnTime;
	}

	public static LocalTime getDispatchTime() {
		return dispatchTime;
	}

	public static void setDispatchTime(LocalTime dispatchTime) {
		OrderScheduler.dispatchTime = dispatchTime;
	}

}
