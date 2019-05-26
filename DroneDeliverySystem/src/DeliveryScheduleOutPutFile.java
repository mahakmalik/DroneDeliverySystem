import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class DeliveryScheduleOutPutFile {
	
	
	
	
		public void creatingOutPutFile(String OutputFileName, int NPS, LinkedHashMap<String,LocalTime> processedOrderdetails) throws IOException {
			 
			BufferedWriter writer = null;
			File file = null;
			FileWriter fileWriter = null;
			
			
			try {
				file = new File(OutputFileName);
				fileWriter = new FileWriter(file);
				
				// create file if not exists
				if (!file.exists()) {
					file.createNewFile();
				}
				
				// initialize BufferedWriter
				writer = new BufferedWriter(fileWriter);

				//write processed List
				
				for (Map.Entry<String,LocalTime> entry : processedOrderdetails.entrySet())  {
					
					String output = entry.getKey() + " " + entry.getValue().toString() ;
					writer.write(output);
					writer.newLine();
					
				}
								
				writer.append(Integer.toString(NPS));
				
				
			} 
			
			catch (Exception e) {
				
				e.printStackTrace();
				
			} 
			finally {
				
				// close BufferedWriter
				if (writer != null) {
					
					try {
						
						writer.close();
						
					} catch (IOException e) {
						
						e.printStackTrace();
						
					}
				}
				// close FileWriter
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


