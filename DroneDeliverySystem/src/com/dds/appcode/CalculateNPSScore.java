package com.dds.appcode;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedHashMap;

public class CalculateNPSScore {
	
	private static  LinkedHashMap<String,LocalTime> processedOrderDetails = new LinkedHashMap<String,LocalTime>();
	private static int promotors;
	private static int detractors;
	private static int NPS;
	private static int totalProcessedOrders;

	public static void calculateNPS(OrderDetails order, LocalTime deliveryTime,LocalTime currDispatchTime ) {
		
		
	   //This will calculate the time diferrence between the order place time and delivery time
		long timeElapsed = Duration.between(order.getOrderPlaceTime(),deliveryTime).toMinutes();
		
		if(timeElapsed <120) {
			promotors ++;
			
		}
		
		if(timeElapsed >= 240) {
			
			detractors++;
		}
		
		totalProcessedOrders++;
		//the details that are processed are added to the processed file
		processedOrderDetails.put(order.getOrderId(),currDispatchTime);
		
	}
	
	public int finalCalculation() {
		
		if(totalProcessedOrders == 0) {
			
			return 0;
		}
		
		NPS = ((promotors - detractors ) * 100) / totalProcessedOrders;
		
		return NPS;
		
		
	}
	
	public void callDeliveryScheduleOutPutFile() throws IOException {
		//This will call the class that will write the processedOrderdetails to the output file
		DeliveryScheduleOutPutFile dsf = new DeliveryScheduleOutPutFile();
		dsf.creatingOutPutFile(MainClass.OUTPUT_FILE_PATH, NPS, processedOrderDetails) ;
	}
	
	
}
