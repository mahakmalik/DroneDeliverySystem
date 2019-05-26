import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedHashMap;

public class calculateNPSScore {
	
	private static  LinkedHashMap<String,LocalTime> processedOrderDetails = new LinkedHashMap<String,LocalTime>();
	private static int promotors;
	private static int detractors;
	private static int NPS;
	private static int totalProcessedOrders;

	public static void calculateNPS(OrderDetails order, LocalTime deliveryTime ) {
		
		
	
		int timeElapsed = (int) Duration.between(deliveryTime, order.getOrderPlaceTime()).toHours();
		
		
		
		if(timeElapsed <=1) {
			promotors ++;
			
		}
		
		if(timeElapsed >= 4) {
			
			detractors++;
		}
		
		totalProcessedOrders++;
		
		processedOrderDetails.put(order.getOrderId(),deliveryTime);
		
	}
	
	public int finalCalculation() {
		
		if(totalProcessedOrders == 0) {
			
			return 0;
		}
		
		NPS = ((promotors - detractors ) * 100) / totalProcessedOrders;
		
		return NPS;
		
		
	}
	
	public void callDeliveryScheduleOutPutFile() throws IOException {
		
		DeliveryScheduleOutPutFile dsf = new DeliveryScheduleOutPutFile();
		dsf.creatingOutPutFile(Properties.getOUTPUT_FILE_PATH(), NPS, processedOrderDetails) ;
	}
	
	
}
