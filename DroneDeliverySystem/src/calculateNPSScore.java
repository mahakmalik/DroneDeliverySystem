import java.time.Duration;
import java.time.LocalTime;

public class calculateNPSScore {
	
	private static int promotors;
	private static int detractors;
	private static int NPS;
	private static int totalProcessedOrders;

	public static void calculateNPS(OrderDetails order, LocalTime deliveryTime ) {
		
		OrderFileProcessor ofp = new OrderFileProcessor();
		
		int timeElapsed = (int) Duration.between(deliveryTime, order.getOrderPlaceTime()).toHours();
		
		if(timeElapsed <=1) {
			promotors ++;
			
		}
		
		if(timeElapsed >= 4) {
			
			detractors++;
		}
		
		totalProcessedOrders++;
		
		ofp.getProcessedOrderDetails().put(order.getOrderId(),deliveryTime);
		
	}
	
	public int finalCalculation() {
		
		if(totalProcessedOrders == 0) {
			
			return 0;
		}
		
		NPS = ((promotors - detractors ) * 100) / totalProcessedOrders;
		
		return NPS;
		
		
	}
	
	
	
}
