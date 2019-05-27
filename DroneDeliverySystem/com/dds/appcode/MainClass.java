package com.dds.appcode;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;



/*** Purpose of this class is to set the initial configurations
     set the store operation hours
     Input and output file path
***/
public class MainClass {
	
	public static final LocalTime OPEN_STORE_TIME = LocalTime.of(6, 0,0);
    public static final LocalTime CLOSE_STORE_TIME = LocalTime.of(22, 0,0);
    public static final String INPUT_FILE_PATH = new File("").getAbsolutePath() +  "\\src\\InputFileRows.txt";
    public static final String OUTPUT_FILE_PATH = new File("").getAbsolutePath() +  "\\src\\OutputFileRows.txt";
   
   
	public static void main(String[] args) throws IOException {
		
		//creating the object of class that will process the input file
		 OrderFileProcessor initial = new OrderFileProcessor();
		 initial.bufferedReaderToArrayList(MainClass.INPUT_FILE_PATH);
		
				 
		 CalculateNPSScore nps= new CalculateNPSScore();
		 nps.finalCalculation();
		 nps.callDeliveryScheduleOutPutFile();
		 
	}

	

}
