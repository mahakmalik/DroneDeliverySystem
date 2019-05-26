import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Map;

public class DeliveryScheduleOutPutFile {

	OrderFileProcessor ofp = new OrderFileProcessor();
	
		public void creatingOutPutFile(String OutputFileName, int NPS) throws IOException {
			 
			BufferedWriter writer = null;
			File file = null;
			FileWriter fileWriter = null;
			DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
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
				
				for (Map.Entry<String,LocalTime> entry : ofp.getProcessedOrderDetails().entrySet())  {
					
					String output = entry.getKey() + " " +dateFormat.format(entry.getValue()) ;
					
					writer.append(output);
					writer.newLine();
					
				}
								
				writer.append(Integer.toString(NPS));
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
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


