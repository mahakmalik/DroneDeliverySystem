package com.dds.appcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.dds.exceptions.FileNotFoundException;
import com.dds.exceptions.ListEmptyException;
import com.dds.exceptions.MalformedFileDataException;

/***
 * Purpose of this class is to read the input file Validate the contents of the
 * Input file This class will create the order list from input file A sorted
 * order list has been created according to the round trip time
 * 
 ***/

public class OrderFileProcessor {

	private ArrayList<OrderDetails> custOrderDetails = new ArrayList<OrderDetails>();
	private ArrayList<OrderDetails> sortedTripOrderDetails = new ArrayList<OrderDetails>();

	// method to read the input file
	public void bufferedReaderToArrayList(String path) throws FileNotFoundException, MalformedFileDataException, ListEmptyException {

		// using Java inbuilt class BufferedReader to read the Input File
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			// check if file is empty and throw custom exception if it is
			File file = new File(path);
			if (file.length() == 0 || !file.exists())
				throw new FileNotFoundException("Either the File is empty or does not exist!");

			String orderDetails = reader.readLine();
			String[] orderDetails_trimmed = null;

			while (orderDetails != null) {
				orderDetails = reader.readLine();

				// Each order row is split by whitespace
				if (orderDetails != null) {
					orderDetails_trimmed = orderDetails.trim().split("\\s+");
				}

				if (!checkTheValidityOfTheEntry(orderDetails_trimmed))
					throw new MalformedFileDataException("File contains malformed entries!");

				// orderPlacetime is converted to LocalTime object from string
				LocalTime orderPlaceTime = LocalTime.parse(orderDetails_trimmed[2]);
				// create order method is created and details in each line is passed
				createOrderList(orderDetails_trimmed[0], orderDetails_trimmed[1], orderPlaceTime);
			}
			// sorted trip is not sorted before calling this function,it gets sorted after
			// this function is called
			if(!custOrderDetails.isEmpty()) {
				sortList(this.custOrderDetails);
			}
			else {
				throw new ListEmptyException("List is Empty!");
			}
			
		} catch (IOException e) {
			throw new FileNotFoundException("Either the File is empty or does not exist!");
		} 
//		catch (ListEmptyException e) {
//			throw new ListEmptyException("Either the File is empty or does not exist!");
//		}
	}

	public void createOrderList(String orderId, String location, LocalTime orderPlaceTime){
		// the details of each order is passed to OrderDetails.java constructor
		OrderDetails order = new OrderDetails(orderId, location, orderPlaceTime);
		// the object of each order is stored into the custOrderdetails and
		// sortedTripOrderDetails
		if(order != null){
			// this.sortedTripOrderDetails.add(order);
			this.custOrderDetails.add(order);
		}
	}

	public void sortList(ArrayList<OrderDetails> custOrderDetails) throws ListEmptyException{
		// sortedTripOrderDetails.sort(Comparator.comparingDouble(OrderDetails::getRoundTripTime));
		if(!custOrderDetails.isEmpty()) {
			this.sortedTripOrderDetails = (ArrayList<OrderDetails>) custOrderDetails.stream()
					.sorted(Comparator.comparingDouble(OrderDetails::getRoundTripTime)).collect(Collectors.toList());
			new OrderScheduler().orderSelection(sortedTripOrderDetails, custOrderDetails);
		}	
		else {
			throw new ListEmptyException("List is Empty!");
		}
		// once we have all the required list we call the method callscheduler to pass
		// the list to OrderScheduler.java
		
	}

//	public void scheduler() throws ListEmptyException{
//		// now we can access the contents of the list in OrderScheduler.java
//		//OrderScheduler os = new OrderScheduler(sortedTripOrderDetails, custOrderDetails);
//		// once the list are visible to OrderScheduler then processing method is called
//		// for order selection
//		
//	}

	public boolean checkTheValidityOfTheEntry(String[] splited) {	

		if(splited.length==3) {

			if(splited[0].matches("WM\\d{4}") && splited[1].matches("[NEWS]\\d+[NEWS]\\d+") 
					&& LocalTime.parse(splited[2]).isAfter(LocalTime.parse("4:30:00")) || 
					LocalTime.parse(splited[2]).isBefore(LocalTime.parse("10:00:00"))) {
				return true;
			}else return false;

		}
		else return false;
	}

	// Getters and Setters for custOrderDetails and sortedTripOrderDetails
	// ArrayLists
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
