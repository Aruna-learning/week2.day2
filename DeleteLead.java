package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	//1.Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		 
	//2. Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
	//3. Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(2000);
		
	//4. Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		Thread.sleep(5000);
		
	//5. Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(5000);
		
	//6. Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(5000);
		
	//7. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);
		
	//8. Click on Phone
		driver.findElementByXPath("//span[text()='Phone']").click();
		Thread.sleep(5000);
		
	//9. Enter phone number
		driver.findElementByName("phoneCountryCode").clear();
		driver.findElementByName("phoneCountryCode").sendKeys("1");
		driver.findElementByName("phoneAreaCode").sendKeys("1");
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("91");
		
	//10. Click find leads button
		driver.findElementByLinkText("Find Leads").click();
		Thread.sleep(5000);
		
	//11. Capture lead ID of First Resulting lead
		WebElement text1 = driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a[1]");
		String text = text1.getText();
		System.out.println("The First Resulting Lead is "+text);
		Thread.sleep(4000);
		
	//12. Click First Resulting lead
		text1.click();
		Thread.sleep(5000);
		
	//13. Click Delete
		driver.findElementByLinkText("Delete").click();
		Thread.sleep(5000);
		
	//14. Click Find leads
		driver.findElementByLinkText("Find Leads").click();
		
	//15. Enter captured lead ID
		driver.findElementByXPath("//label[text()='Lead ID:']//following::input").sendKeys(text);
		
	//16. Click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
	//17. Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	String eString="No records to display";
	String aString = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
	if(aString.equals(eString))
		System.out.println("Successful deletion");
	else
		System.out.println("Unsuccessful deletion");
	Thread.sleep(4000);
	
	//18. Close the browser (Do not log out)
		driver.close();
		Thread.sleep(2000);
		System.out.println("The browser is closed successfully");


	}

}
