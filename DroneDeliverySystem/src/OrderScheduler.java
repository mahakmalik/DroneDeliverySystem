import java.time.LocalTime;
import java.util.ArrayList;

public class OrderScheduler{
	private static LocalTime dispatchTime;
	private LocalTime deliveryTime;
	private LocalTime returnTime;
	private  ArrayList<OrderDetails> custOrderDetails;
	private  ArrayList<OrderDetails> sortedTripOrderDetails;
	
	//to get the order list created while processing the input file
	
	OrderScheduler(ArrayList<OrderDetails> sortedTripOrderDetails , ArrayList<OrderDetails> custOrderDetails ) {
		
		sortedTripOrderDetails = new ArrayList<OrderDetails>();  
		  this.sortedTripOrderDetails.addAll(sortedTripOrderDetails);
		  
		  custOrderDetails = new ArrayList<OrderDetails>();  
		  this.sortedTripOrderDetails.addAll(custOrderDetails); 
		
	}
	//to get the order list created while processing the input file

	
	public void processing(LocalTime currDispatchTime) {
		
		OrderDetails order = selectNextOrder(currDispatchTime);
		
		int len=custOrderDetails.size();
		
			for(int i=0;i<len-1;i++) {	
				
				System.out.println("for");
				
				if(order.getOrderPlaceTime().isAfter(currDispatchTime)) {	
					
					currDispatchTime = order.getOrderPlaceTime();
				}

			currDispatchTime=currDispatchTime.plusMinutes(1);
			
			deliveryTime = getDeliveryTime(order,currDispatchTime);
			
			//when the drone comes back to the base;                     
			returnTime = getDeliveryTime(order,currDispatchTime); ;
			
			calculateNPSScore.calculateNPS(order,deliveryTime);	
			
			currDispatchTime = returnTime;
			
			System.out.println(order.getOrderId());
			
			sortedTripOrderDetails.remove(order);
			custOrderDetails.remove(order);
			
			order = selectNextOrder(currDispatchTime);
						
			
			}
		


	}

	//we are selecting the order that should be picked next.
	public OrderDetails selectNextOrder(LocalTime currentDispatchTime) {
		
		
		OrderDetails order = sortedTripOrderDetails.stream()
				.filter(o->currentDispatchTime.isAfter(o.getOrderPlaceTime()) || currentDispatchTime.equals(o.getOrderPlaceTime()))
				.findAny()
				.orElse(null);
		

		//get the order with the earliest order place time if no orders were found
		if (order == null && !custOrderDetails.isEmpty()) {
			order = custOrderDetails.get(0);
		}
		
		return order;


		
	}


	public LocalTime getDeliveryTime(OrderDetails prevOrder, LocalTime currDispatchTime) {
			
			int minutes = (int) (prevOrder.getRoundTripTime()/2);
			
			deliveryTime = currDispatchTime.plusMinutes(minutes) ;
		
		return deliveryTime;


	}

	public LocalTime getReturnTime(OrderDetails prevOrder, LocalTime currDispatchTime) {
		
		int minutes = (int) (prevOrder.getRoundTripTime());
		
		returnTime = currDispatchTime.plusMinutes(minutes) ;
	
	return returnTime;


}

	public static LocalTime getDispatchTime() {
		return dispatchTime;
	}

	public static void setDispatchTime(LocalTime dispatchTime) {
		OrderScheduler.dispatchTime = dispatchTime;
	}

	


}
