package com.dds.appcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.dds.exceptions.FileNotFoundException;
import com.dds.exceptions.ListEmptyException;
import com.dds.exceptions.MalformedFileDataException;

/**
 * OrderFileProcessor.java - Purpose of this class is to read the input file,
 * validate its contents and process it.
 * 
 * @author Mahak Malik
 * @version 1.0 *
 */
public class OrderFileProcessor {

	private ArrayList<OrderDetails> custOrderDetails = new ArrayList<OrderDetails>();
	private ArrayList<OrderDetails> sortedTripOrderDetails = new ArrayList<OrderDetails>();

	/**
	 * Process the orders file provided as input, call checkTheValidityOfTheEntry()
	 * and createOrderList()
	 * 
	 * @param path
	 * @throws FileNotFoundException      - If the file is not found at the provided
	 *                                    path
	 * @throws MalformedFileDataException - If the file contains malformed data
	 * @throws ListEmptyException
	 */
	public void bufferedReaderToArrayList(String path)
			throws FileNotFoundException, MalformedFileDataException, ListEmptyException {

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

				// check if file data is valid
				if (!checkTheValidityOfTheEntry(orderDetails_trimmed))
					throw new MalformedFileDataException("File contains malformed entries!");

				LocalTime orderPlaceTime = LocalTime.parse(orderDetails_trimmed[2]);
				createOrderList(orderDetails_trimmed[0], orderDetails_trimmed[1], orderPlaceTime);
			}

			// check if custOrderDetails list is not empty and sort the list
			if (!custOrderDetails.isEmpty()) {
				sortList(this.custOrderDetails);
			} else {
				throw new ListEmptyException("List is Empty!");
			}

		} catch (IOException e) {
			throw new FileNotFoundException("Either the File is empty or does not exist!");
		}
	}

	/**
	 * Create an ArrayList custOrderDetails with objects of class OrderDetails.
	 * 
	 * @param orderId         - unique order ID for each order
	 * @param deliverLocation - location where order needs to be delivered
	 * @param orderPlaceTime  - time at which the order was placed
	 * @see OrderDetails
	 */
	public void createOrderList(String orderId, String deliveryLocation, LocalTime orderPlaceTime) {
		OrderDetails order = new OrderDetails(orderId, deliveryLocation, orderPlaceTime);
		if (order != null) {
			this.custOrderDetails.add(order);
		}
	}

	/**
	 * Sort the custOrderDetails list according to the round trip time from
	 * warehouse to delivery location.
	 * 
	 * @param custOrderDetails - list of OrderDetails objects
	 * @throws ListEmptyException - If custOrderDetails list is empty
	 */
	public void sortList(ArrayList<OrderDetails> custOrderDetails) throws ListEmptyException {
		if (!custOrderDetails.isEmpty()) {
			this.sortedTripOrderDetails = (ArrayList<OrderDetails>) custOrderDetails.stream()
					.sorted(Comparator.comparingDouble(OrderDetails::getRoundTripTime)).collect(Collectors.toList());
			new OrderScheduler().orderSelection(sortedTripOrderDetails, custOrderDetails);
		} else {
			throw new ListEmptyException("List is Empty!");
		}
	}

	/**
	 * Check if order entry in orders file (input) is valid
	 * 
	 * @param orderDetails_trimmed - String array of order details split by
	 *                             whitespace into orderID, deliveryLocation,
	 *                             orderPlaceTime
	 * @return A boolean data type.
	 */
	public boolean checkTheValidityOfTheEntry(String[] orderDetails_trimmed) {

		if (orderDetails_trimmed.length == 3) {

			if (orderDetails_trimmed[0].matches("WM\\d{4}") && orderDetails_trimmed[1].matches("[NEWS]\\d+[NEWS]\\d+")
					&& LocalTime.parse(orderDetails_trimmed[2]).isAfter(LocalTime.parse("4:30:00"))
					|| LocalTime.parse(orderDetails_trimmed[2]).isBefore(LocalTime.parse("22:00:00"))) {
				return true;
			} else
				return false;

		} else
			return false;
	}

	/**
	 * Retrieve the custOrderDetails List
	 * 
	 * @return An ArrayList.
	 */
	public ArrayList<OrderDetails> getCustOrderDetails() {
		return custOrderDetails;
	}

	/**
	 * Retrieve sorted sortedTripOrderDetails list.
	 * 
	 * @return An ArrayList.
	 */
	public ArrayList<OrderDetails> getSortedTripOrderDetails() {
		return sortedTripOrderDetails;
	}

}
