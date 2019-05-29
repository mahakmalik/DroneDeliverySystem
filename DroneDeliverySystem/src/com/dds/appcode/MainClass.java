package com.dds.appcode;
import java.io.File;
import java.time.LocalTime;

import com.dds.exceptions.FileNotFoundException;
import com.dds.exceptions.ListEmptyException;
import com.dds.exceptions.MalformedFileDataException;



/**
 * MainClass.java - Initializes the program and sets 
 * program assumptions and paths of input and output files
 * @author Mahak Malik
 * @version 1.0
 */
public class MainClass {
	
	public static final LocalTime OPEN_STORE_TIME = LocalTime.of(6, 0,0);
    public static final LocalTime CLOSE_STORE_TIME = LocalTime.of(22, 0,0);
    public static final String INPUT_FILE_PATH = new File("").getAbsolutePath() +  "\\src\\InputFileRows.txt";
    public static final String OUTPUT_FILE_PATH = new File("").getAbsolutePath() +  "\\src\\OutputFileRows.txt";   
   
    /**
     * This is the program's entry point. Calls bufferdReaderToArrayList() method with the orders file as input.
     * @param args - Arguments for main function. Unused at this point.
     * @throws FileNotFoundException If the file is missing, has wrong path, or is not a valid text file
     * @throws MalformedFileDataException If the file contains malformed data
     * @throws ListEmptyException - If List is empty.
     */
	public static void main(String[] args) throws FileNotFoundException, MalformedFileDataException, ListEmptyException{		
		//creating the object of class that will process the input file
		 OrderFileProcessor initial = new OrderFileProcessor();
		 if(initial!=null) {
			 try {
				initial.bufferedReaderToArrayList(INPUT_FILE_PATH);
			} catch (FileNotFoundException e) {
				throw new FileNotFoundException("Either the File is empty or does not exist!");
			} catch (MalformedFileDataException e) {
				throw new MalformedFileDataException("File contains malformed entries!");
			}

		 }	
				 
		 CalculateNPSScore nps= new CalculateNPSScore();
		 nps.finalCalculation();
		 try {
			nps.callDeliveryScheduleOutPutFile();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found or cannot be created!");
		}
		 
	}

	

}
