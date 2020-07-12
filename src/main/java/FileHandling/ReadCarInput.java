package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class ReadCarInput {
	
	public List<String> RegNumber = new ArrayList<String>();
	
	@SuppressWarnings("resource")
	public List<String> CarInputReg()
	{
	// Variables
		BufferedReader reader;
		String line;
		Matcher regMatch;
		String regValue;
		
	// RegEx Patterns To Check
			
		//Pattern pIf1 = Pattern.compile("(?=[A-Z]{2}[0-9]{2}[\s])[A-Z]{2}[0-9]{2}[\s][A-Z]{3}|[A-Z]{2}[0-9]{2}[A-Z]{3}");
		Pattern p1 = Pattern.compile("([A-Z]{2}[0-9]{2})([\s])([A-Z]{3})"); // Registration with Space
		Pattern p2 = Pattern.compile("([A-Z]{2}[0-9]{2}[A-Z]{3})"); // Registration without Space
		
		try {

			reader = new BufferedReader(new FileReader("/java/car_input.txt"));
			line = reader.readLine();

		// Checks if no more lines from file
			while(line != null)
			{
			// Check for Registration with Space
				regMatch = p1.matcher(line);
				if (regMatch.find())
				{
					regValue = regMatch.group();
					
					// Remove Space
					RegNumber.add(regValue.replaceAll("\\s+",""));
				}
				
			// Check for Registration without Space
				regMatch = p2.matcher(line);
				if (regMatch.find())
				{
					regValue = regMatch.group();
					RegNumber.add(regValue);
				}
				
				line = reader.readLine();
			}
			
			return RegNumber;
		}
		catch (IOException e) {
			e.printStackTrace();
			RegNumber.clear();
			return RegNumber;
		}
	}
}
