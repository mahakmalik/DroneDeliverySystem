package com.dds.appcode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/***
 * Purpose of this class is to read the input file Validate the contents of the Input file
 *  This class will create the order list from input file
 *  A sorted order list has been created according to the round trip time
 * 
 ***/

public class OrderFileProcessor {

	private ArrayList<OrderDetails> custOrderDetails = new ArrayList<OrderDetails>();
	private ArrayList<OrderDetails> sortedTripOrderDetails = new ArrayList<OrderDetails>();

	// method to read the input file
	public void bufferedReaderToArrayList(String path) {

		//using Java inbuilt class bufferreader to read the Input File
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			//check if file is empty
                File file = new File(path);
                if(file.length() ==0 || !file.exists()) return;
			
			String line = reader.readLine();
			String[] splited = null;
			
			while (line != null) {
				line = reader.readLine();
                
				
				
				//Each row is split according to the space
				if (line != null) {
					splited = line.trim().split("\\s+");
				}
				
				if(!checkTheValidityOfTheEntry(splited)) continue;

				//Order place time is converted to LocalTime datatype from string
				LocalTime orderPlaceTime = LocalTime.parse(splited[2]);
				//create order method is created and details in each line is passed
				createOrderList(splited[0], splited[1], orderPlaceTime);
			}
			//sorted trip is not sorted before calling this function,it gets sorted after this function is called
			sortList(getSortedTripOrderDetails());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 		
		
	}

	public void createOrderList(String orderId, String location, LocalTime orderPlaceTime) {
        //the details of each order is passed to OrderDetails.java constructor
		OrderDetails order = new OrderDetails(orderId, location, orderPlaceTime);
        //the object of each order is stored into the custOrderdetails and sortedTripOrderDetails
		getSortedTripOrderDetails().add(order);
		getCustOrderDetails().add(order);

	}

	public void sortList(List<OrderDetails> sortedTripOrderDetails) {
		sortedTripOrderDetails.sort(Comparator.comparingDouble(OrderDetails::getRoundTripTime));
        //once we have all the required list we call the method callscheduler to pass the list to OrderScheduler.java
		callScheduler();
	}

	public void callScheduler() {
        //now we can access the contents of the list in OrderScheduler.java
		OrderScheduler os = new OrderScheduler(sortedTripOrderDetails, custOrderDetails);
		//once the list are visible to OrderScheduler then processing method is called for order selection
		os.orderSelection(MainClass.OPEN_STORE_TIME);

	}
	
	public boolean checkTheValidityOfTheEntry(String[] splited) {	
		if( !(splited.length ==3 ) && splited[0].matches("WM\\d{4}") && splited[1].matches("[NEWS]\\d+[NEWS]\\d+") 
			&& LocalTime.parse(splited[2]).isAfter(LocalTime.parse("4:30:00")) || LocalTime.parse(splited[2]).isBefore(LocalTime.parse("10:00:00")))
		
		return true;
		
		else return false;
	}

	public ArrayList<OrderDetails> getCustOrderDetails() {
		return custOrderDetails;
	}

	public void setCustOrderDetails(ArrayList<OrderDetails> custOrderDetails) {
		this.custOrderDetails = custOrderDetails;
	}

	public ArrayList<OrderDetails> getSortedTripOrderDetails() {
		return sortedTripOrderDetails;
	}

	public void setSortedTripOrderDetails(ArrayList<OrderDetails> sortedTripOrderDetails) {
		this.sortedTripOrderDetails = sortedTripOrderDetails;
	}

}
