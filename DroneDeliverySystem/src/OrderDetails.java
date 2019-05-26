import java.time.LocalTime;



public class OrderDetails {
	
	
	    private String orderId;
	    private double roundTripTime;
	    private LocalTime orderPlaceTime;
	    
	   
	    //asdfjnsdkjvn
	    
	    public OrderDetails(String orderId, String location, LocalTime orderPlaceTime) {
	        
	    	TripTimeCalculator cal = new TripTimeCalculator();	    	
	        this.setRoundTripTime(cal.calculateTotalTime(location));
	        this.setOrderId(orderId);
	        this.setOrderPlaceTime(orderPlaceTime);
	

}


		public double getRoundTripTime() {
			return roundTripTime;
		}


		public void setRoundTripTime(double transportTime) {
			this.roundTripTime = transportTime;
		}


		public LocalTime getOrderPlaceTime() {
			return orderPlaceTime;
		}


		public void setOrderPlaceTime(LocalTime orderPlaceTime) {
			this.orderPlaceTime = orderPlaceTime;
		}


		public String getOrderId() {
			return orderId;
		}


		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}




		

		

		
	
}
