package CarRegistrationTests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FileHandling.ReadCarOutput;

@RunWith(Parameterized.class)
public class WebBrowserData {
	
	@Parameterized.Parameters(name = "{index}; RegistrationCheck({0}")
	public static List<Object[]> data(){
		
	// Gets Registration from Output File
		ReadCarOutput CarRegOutput = new ReadCarOutput();
		List<Object[]> RegDetails = CarRegOutput.CarOutputReg();
				
		return RegDetails;
		
	}
	
	@Parameterized.Parameter(0)
	public String cRegistration;
	
	@Parameterized.Parameter(1)
	public String cMake;
	
	@Parameterized.Parameter(2)
	public String cModel;
	
	@Parameterized.Parameter(3)
    public String cColour;
	
	@Parameterized.Parameter(4)
    public String cYear;
	
	public String aRegistration;
	public String aMake;
	public String aModel;
	public String aColour;
	public String aYear;
	static WebDriver driver;
	
	@BeforeClass
	public static void setBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://cartaxcheck.co.uk/");
	    driver.manage().window().maximize();
	    
	}
	
	@AfterClass
	public static void CloseBrowser() throws Exception {
		//System.out.println("After");
		driver.close();
	}
	
	@Before
	public void WebRegistrationTest() throws Exception {
		
		driver.findElement(By.id("vrm-input")).sendKeys(cRegistration);
	    driver.findElement(By.xpath("//button[contains(.,\'Free Car Check\')]")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".jsx-1745606755:nth-child(3) > .jsx-3315683148 h4")));
		
	    // Capture Browser Data
	    aRegistration = driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[1]/dd")).getText();
	    aMake = driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[2]/dd")).getText();
	    aModel = driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[3]/dd")).getText();
	    aColour = driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[4]/dd")).getText();
	    aYear = driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[5]/dd")).getText();
	    
	}

	@After
	public void tearDown() throws Exception {
		// Return to Main Page
	    driver.findElement(By.xpath("//div[@id=\'head\']/header/a/img")).click();
	}

	@Test
	public void RegistrationCheck() {
		
		System.out.println("- Start Validating Registration: " + cRegistration);
		
		// Registration
		try {
			assertEquals(cRegistration,aRegistration);
			System.out.println("  - Registration - Expected: '" + cRegistration + "' Actual: '" + aRegistration + "' - Registration Match");
		   }
		catch(AssertionError e) {
			   System.out.println("  - Registration: '" + cRegistration + "' Actual: '" + aRegistration + "' - Registration is Not the Same");
			   fail(cRegistration + ":  - Not Match");
		}	
		
		// Make
		try {
			assertEquals(cMake,aMake);
			System.out.println("  - Make - Expected: '" + cMake + "' Actual: '" + aMake + "' - Make Match");
		   }
		catch(AssertionError e) {
			   System.out.println("  - Make: '" + cMake + "' Actual: '" + aMake + "' - Make is Not the Same");
			   fail(cRegistration + ":  - Make Not Match");
		}
		
		// Model
		try {
			assertEquals(cModel,aModel);
			System.out.println("  - Model - Expected: '" + cModel + "' Actual: '" + aModel + "' - Model Match");
		   }
		catch(AssertionError e) {
			System.out.println("  - Model: '" + cModel + "' Actual: '" + aModel + "' - Model is Not the Same");
			fail(cRegistration + ":  - Model Not Match");
		}

		// Colour
		try {
			assertEquals(cColour,aColour);
			System.out.println("  - Colour - Expected: '" + cColour + "' Actual: '" + aColour + "' - Colour Match");
		   }
		catch(AssertionError e) {
			System.out.println("  - Colour - Expected: '" + cColour + "' Actual: '" + aColour + "' - Colour is Not the Same");
			fail(cRegistration + ":  - Colour Not Match");
		}
		
		// Year
		try {
			assertEquals(cYear,aYear);
			System.out.println("  - Year - Expected: '" + cYear + "' Actual: '" + aYear + "' - Year Match");
		   }
		catch(AssertionError e) {
			System.out.println("  - Year - Expected: '" + cYear + "' Actual: '" + aYear + "' - Year is Not the Same");
			fail(cRegistration + ":  - Year Not Match");
		}
		
		System.out.println(" ");
	}	
}

