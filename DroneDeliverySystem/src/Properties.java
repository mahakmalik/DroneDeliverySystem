import java.io.IOException;
import java.time.LocalTime;



/*** Purpose of this class is to set the initial configurations
     set the store operation hours
     Input and output file path


***/
public class Properties {
	
	private static final String OPEN_STORE_TIME = "06:00:00";
    private static final String CLOSE_STORE_TIME = "22:00:00";
    private static String INPUT_FILE_PATH = "C:\\\\Users\\\\mahak\\\\eclipse-workspace\\\\DroneDeliverySystem\\\\src\\\\InputFileRows";
    private static String OUTPUT_FILE_PATH = "C:\\\\Users\\\\mahak\\\\eclipse-workspace\\\\DroneDeliverySystem\\\\src\\\\OutPutFileRows";
    private static LocalTime OPEN_TIME;
    private static LocalTime CLOSE_TIME;

    //set facility open and close times
    static {
        try {
            setOPEN_TIME(LocalTime.parse(OPEN_STORE_TIME));
        } catch (Exception ex) {
        }
        try {
            setCLOSE_TIME(LocalTime.parse(CLOSE_STORE_TIME));
        } catch (Exception ex) {
        }
    }
    

	public static String getINPUT_FILE_PATH() {
		return INPUT_FILE_PATH;
	}

	private static void setCLOSE_TIME(LocalTime parse) {
		// TODO Auto-generated method stub
		
	}

	public static void setINPUT_FILE_PATH(String iNPUT_PATH) {
		INPUT_FILE_PATH = iNPUT_PATH;
	}	

	public static LocalTime getOPEN_TIME() {
		return OPEN_TIME;
	}

	public static void setOPEN_TIME(LocalTime oPEN_TIME) {
		OPEN_TIME = oPEN_TIME;
	}

	public static LocalTime getCLOSE_TIME() {
		// TODO Auto-generated method stub
		return CLOSE_TIME;
	}
	
	public static String getOUTPUT_FILE_PATH() {
		return OUTPUT_FILE_PATH;
	}

	public static void setOUTPUT_FILE_PATH(String oUTPUT_FILE_PATH) {
		OUTPUT_FILE_PATH = oUTPUT_FILE_PATH;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 OrderFileProcessor initial = new OrderFileProcessor();
		 initial.bufferedReaderToArrayList(Properties.getINPUT_FILE_PATH());
		
		
		 
		 /*calculateNPSScore nps= new calculateNPSScore();
		 int score= nps.finalCalculation();

		 DeliveryScheduleOutPutFile dsf = new DeliveryScheduleOutPutFile();
		 dsf.creatingOutPutFile(OUTPUT_FILE_PATH , score);*/
	}

	

}
