package com.dds.appcode;

public class TripTimeCalculator {

	// Calculate total trip time for a delivery
	public double calculateTotalTime(String location) {
		double tripTime = 0.00;
		if (location != null) {
			String[] splited = location.trim().split("[NWES]");

			double oneDir = Math.pow(Double.parseDouble(splited[1]), 2);
			double secDir = Math.pow(Double.parseDouble(splited[2]), 2);

			tripTime = Math.round((2 * Math.sqrt(oneDir + secDir)) * 100.0) / 100.0;

		}

		return tripTime;

	}

}
