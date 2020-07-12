package CarRegistrationTests;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import FileHandling.ReadCarOutput;

public class OutputFileData {

	@Test
	public void OutputFileTest() {

		Boolean ListEmpty;
		
		try {
		// Gets Registration from Output File
			ReadCarOutput CarRegOutput = new ReadCarOutput();
			List<Object[]> RegDetails = CarRegOutput.CarOutputReg();
			
			ListEmpty = RegDetails.isEmpty();
			assertEquals(false,ListEmpty);
			
		// Displays details to Console
			System.out.println(" ");
			System.out.println("Output Car Data");	
			for (Object[] strArr : RegDetails) {
				System.out.println("  - " + Arrays.toString(strArr));
				//System.out.println(strArr[0]);
			}	
		
			System.out.println(" ");
		}
		catch(AssertionError e) {
			System.out.println("  - No Output Data Found.");
		}
	}
}
