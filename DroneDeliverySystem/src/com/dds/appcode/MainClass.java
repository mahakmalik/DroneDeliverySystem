package com.dds.appcode;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import com.dds.exceptions.FileNotFoundException;
import com.dds.exceptions.MalformedFileDataException;



/*** Purpose of this class is to set the initial configurations
     set the store operation hours
     Input and output file path
***/
public class MainClass {
	
	public static final LocalTime OPEN_STORE_TIME = LocalTime.of(6, 0,0);
    public static final LocalTime CLOSE_STORE_TIME = LocalTime.of(22, 0,0);
    public static final String INPUT_FILE_PATH = new File("").getAbsolutePath() +  "\\src\\InputFileRows.txt";
    public static final String OUTPUT_FILE_PATH = new File("").getAbsolutePath() +  "\\src\\OutputFileRows.txt";
   
   
	public static void main(String[] args) throws FileNotFoundException, MalformedFileDataException{
		
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	

}
