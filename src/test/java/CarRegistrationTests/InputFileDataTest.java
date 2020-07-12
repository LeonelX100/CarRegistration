package CarRegistrationTests;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import FileHandling.ReadCarInput;

public class InputFileDataTest {

	@Test
	public void InputFileTest() {
		
		List<String> RegNumber = new ArrayList<String>();
		Boolean ListEmpty;
		
		try {
			
			System.out.println("Input File Checks");
					
		// Gets Registration from Input File
			ReadCarInput CarReg = new ReadCarInput();
			RegNumber = CarReg.CarInputReg();
			
			ListEmpty = RegNumber.isEmpty();
			assertEquals(false,ListEmpty);
			
		// List Input File Registration 
			int numReg = RegNumber.size();
			System.out.println("  - Valid Car Registration");						
			for(int i=0; i < numReg; i++){
				System.out.println("    - " + RegNumber.get(i));
			}
			
			System.out.println(" ");
		}
		catch(AssertionError e) {
			System.out.println("  - No Valid Car Registration Found.");
		}
	}

}
