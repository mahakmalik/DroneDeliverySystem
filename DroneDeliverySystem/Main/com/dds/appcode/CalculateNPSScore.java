package com.dds.appcode;
import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedHashMap;

import com.dds.exceptions.FileNotFoundException;

/**
 * Class to calculate NPS 
 * @author Mahak Malik
 *
 */
public class CalculateNPSScore {
	
	private static  LinkedHashMap<String,LocalTime> processedOrderDetails = new LinkedHashMap<String,LocalTime>();
	public static int promotors;
	public static int detractors;
	public static int NPS;
	public static int totalProcessedOrders;
	
	/**
	 * Calculate NPS of individual orders.
	 * @param order - OrderDetails object representing customer order.
	 * @param deliveryTime - LocalTime object with order deliveryTime.
	 * @param currDispatchTime - LocalTime object with earliest possible dispatch time.	 
	 */
	public static void calculateNPS(OrderDetails order, LocalTime deliveryTime,LocalTime currDispatchTime ) {		
		
	   //Calculate time difference between order place time and delivery time
		long timeElapsed = Duration.between(order.getOrderPlaceTime(),deliveryTime).toMinutes();
		
		if(timeElapsed <120){
			promotors++;			
		}
		
		if(timeElapsed >= 240){			
			detractors++;
		}
		
		totalProcessedOrders++;
		//the details that are processed are added to the processed file
		processedOrderDetails.put(order.getOrderID(),currDispatchTime);		
	}
	
	/**
	 * Calculate final NPS score after processing all orders.
	 * @return Integer value representing final NPS score.
	 */
	public int finalCalculation(){		
		if(totalProcessedOrders == 0){			
			return 0;
		}		
		NPS = ((promotors - detractors ) * 100) / totalProcessedOrders;		
		return NPS;		
	}
	
	/**
	 * Writes to output file.
	 * @throws FileNotFoundException - If output file is not found or cannot be created.
	 */
	public void callDeliveryScheduleOutPutFile() throws FileNotFoundException{
		//This will call the class that will write the processedOrderdetails to the output file
		DeliveryScheduleOutPutFile dsf = new DeliveryScheduleOutPutFile();
		try {
			dsf.creatingOutPutFile(MainClass.OUTPUT_FILE_PATH, NPS, processedOrderDetails) ;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found!");
		}
	}
	
//	/**
//	 * Retrieve value of promotors.
//	 * @return Integer with value of promotors.
//	 */
//	public static int getPromotors() {
//		return promotors;
//	}
//	
//	/**
//	 * Set value of promotors.
//	 * @param promotors - Integer value of promotors.
//	 */
//	public static void setPromotors(int promotors) {
//		CalculateNPSScore.promotors = promotors;
//	}	
	
}
