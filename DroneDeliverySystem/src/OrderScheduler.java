import java.time.LocalTime;
import java.util.ArrayList;

public class OrderScheduler {
	private static LocalTime dispatchTime;
	private LocalTime deliveryTime;
	private LocalTime returnTime;
	private ArrayList<OrderDetails> OrderDetails = new ArrayList<OrderDetails>();
	private ArrayList<OrderDetails> sortedDetails = new ArrayList<OrderDetails>();;

	// this constructor helps to make the sorted and cut order details data
	// available for processing
	OrderScheduler(ArrayList<OrderDetails> sortedTripOrderDetails, ArrayList<OrderDetails> custOrderDetails) {

		this.sortedDetails.addAll(sortedTripOrderDetails);

		this.OrderDetails.addAll(custOrderDetails);

	}

	public void orderSelection(LocalTime currDispatchTime) {

		// initially we call selectNextOrder with dispatch time = Store open time
		OrderDetails order = selectNextOrder(currDispatchTime);

		// the loop will run till all the orders present in the file are processed
		while (order != null) {
			if (order.getOrderPlaceTime().isAfter(currDispatchTime)) {
				currDispatchTime = order.getOrderPlaceTime();
			}
			// we will add 1 minute to the dispatch time according to the assumption that it
			// takes 1 minute for loading of drone
			currDispatchTime = currDispatchTime.plusMinutes(1);
			// calling the delivery function to get the time at which order was delivered to
			// the customer
			deliveryTime = getDeliveryTime(order, currDispatchTime);

			// when the drone comes back to the base;
			returnTime = getDeliveryTime(order, currDispatchTime);

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

	}

	// we are selecting the order that should be picked next.
	public OrderDetails selectNextOrder(LocalTime currentDispatchTime) {

		// We will select the first order present in the sorted list according to the
		// currdispatch time
		OrderDetails order = sortedDetails.stream().filter(o -> currentDispatchTime.isAfter(o.getOrderPlaceTime())
				|| currentDispatchTime.equals(o.getOrderPlaceTime())).findAny().orElse(null);

		// get the order with the earliest order place time if no orders were found
		if (order == null && !OrderDetails.isEmpty()) {
			order = OrderDetails.get(0);
		}

		return order;

	}

	public LocalTime getDeliveryTime(OrderDetails Order, LocalTime currDispatchTime) {

		int minutes = (int) (Order.getRoundTripTime() / 2);

		deliveryTime = currDispatchTime.plusMinutes(minutes);

		return deliveryTime;

	}

	public LocalTime getReturnTime(OrderDetails Order, LocalTime currDispatchTime) {

		int minutes = (int) (Order.getRoundTripTime());

		returnTime = currDispatchTime.plusMinutes(minutes);

		return returnTime;

	}

	public static LocalTime getDispatchTime() {
		return dispatchTime;
	}

	public static void setDispatchTime(LocalTime dispatchTime) {
		OrderScheduler.dispatchTime = dispatchTime;
	}

}
