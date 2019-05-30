package com.dds.appcode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dds.exceptions.FileNotFoundException;

/**
 * Class that writes into output file after all orders are processed
 * 
 * @author Mahak Malik
 *
 */
public class DeliveryScheduleOutPutFile {

	/**
	 * Writes to the final output file.
	 * 
	 * @param outputFileName        - String for output file name.
	 * @param NPS                   - Integer for final NPS.
	 * @param processedOrderdetails - HashMap(orderID,dispatchTime) of all processed
	 *                              orders
	 * @throws FileNotFoundException - If the output file is not found or cannot be
	 *                               created.
	 */
	public void creatingOutPutFile(String outputFileName, int NPS,
			LinkedHashMap<String, LocalTime> processedOrderdetails) throws FileNotFoundException {

		BufferedWriter writer = null;
		File file = null;
		FileWriter fileWriter = null;

		try {
			file = new File(outputFileName);
			fileWriter = new FileWriter(file);

			if (!file.exists()) {
				file.createNewFile();
			}

			writer = new BufferedWriter(fileWriter);
			// write processed List

			for (Map.Entry<String, LocalTime> entry : processedOrderdetails.entrySet()) {

				String output = entry.getKey() + " " + entry.getValue().toString();
				writer.append(output);
				writer.newLine();
			}

			writer.append(Integer.toString(NPS));
		} catch (IOException e) {
			throw new FileNotFoundException("File not found!");
		} finally {
			if (writer != null) {
				try {
					CalculateNPSScore.NPS=0;
					CalculateNPSScore.promotors=0;
					CalculateNPSScore.detractors=0;
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fileWriter != null) {
						try {
							fileWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}
	}
}
