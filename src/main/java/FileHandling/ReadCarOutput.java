package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCarOutput {
	
	public List<Object[]> outputRegDetails = new ArrayList<Object[]>();
	
	public List<Object[]> CarOutputReg()
	{
	// Variables
		BufferedReader reader;
		String line;
		String[] arraylist;
		
		try {

			reader = new BufferedReader(new FileReader("/java/car_output.txt"));
			line = reader.readLine();
			
		// Checks if no more lines from file
			Boolean header = false;
			while(line != null)
			{
				if(header == false) {header = true; }
				else
				{
					arraylist = line.split(",");
					
					outputRegDetails.add(arraylist);
				}
				
				line = reader.readLine();
			}
			
			reader.close();			
			return outputRegDetails;
		}
		catch (IOException e) {
			e.printStackTrace();
			outputRegDetails.clear();
			return outputRegDetails;
		}
	}
}
