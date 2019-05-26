import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;


/*** Purpose of this class is to read the input file
     Validate the contents of the Input file
     all the lines should contain orderID, Location and Time    
 ***/

public class OrderFileProcessor {


	private  ArrayList<OrderDetails> custOrderDetails = new ArrayList<OrderDetails>();
	private  ArrayList<OrderDetails> sortedTripOrderDetails = new ArrayList<OrderDetails>();
	private  LinkedHashMap<String,LocalTime> processedOrderDetails = new LinkedHashMap<String,LocalTime>();
	


	// method to read the input file
	public void bufferedReaderToArrayList(String path){


		BufferedReader reader;

		try {

			reader = new BufferedReader(new FileReader(path));

			String line = reader.readLine();

			String[] splited = null;

			while(line != null) {

				line = reader.readLine();

				if(line != null) {

					splited = line.trim().split("\\s+");				 
				}

				LocalTime orderPlaceTime=LocalTime.parse(splited[2]);

				createOrderList(splited[0],splited[1],orderPlaceTime);

			}

			reader.close();

		}catch(IOException e){

			e.printStackTrace();

		}

		sortList(getSortedTripOrderDetails());

	}

	public void createOrderList(String orderId, String location, LocalTime orderPlaceTime) {
		
		OrderDetails order = new OrderDetails(orderId, location, orderPlaceTime);
		
		getSortedTripOrderDetails().add(order);
		getCustOrderDetails().add(order);

	}

	public void sortList(List<OrderDetails> sortedTripOrderDetails) {

		sortedTripOrderDetails.sort(Comparator.comparingDouble(OrderDetails::getRoundTripTime));	
				
	}
	
public void callScheduler() {
	
	    OrderScheduler os = new OrderScheduler(sortedTripOrderDetails,custOrderDetails);
		os.processing(Properties.getOPEN_TIME());
		
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

	public LinkedHashMap<String, LocalTime> getProcessedOrderDetails() {
		return processedOrderDetails;
	}

	public void setProcessedOrderDetails(LinkedHashMap<String, LocalTime> processedOrderDetails) {
		this.processedOrderDetails = processedOrderDetails;
	}

	

}
