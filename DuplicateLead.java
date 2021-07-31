package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	//1.	Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		
	//2.	Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
	//3.	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(2000);
		
	//4.	Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		Thread.sleep(5000);
		
	//5.	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(5000);
		
	//6.	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(5000);
		
	//7.	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);
		
	//8.	Click on Email
		driver.findElementByXPath("(//span[@class='x-tab-strip-text '])[3]").click();
		
	//9.	Enter Email
		driver.findElementByName("emailAddress").sendKeys("sanjay");
		
	//10.	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		
	//11.	Capture name of First Resulting lead
		WebElement text1 = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]");
		String firsttext = text1.getText();
		System.out.println("Name of the first text is "+firsttext);
		Thread.sleep(4000);
		
	//12.	Click First Resulting lead
		text1.click();
		Thread.sleep(5000);
		
	//13.	Click Duplicate Lead
		driver.findElementByLinkText("Duplicate Lead").click();
		Thread.sleep(5000);
		
	//14.	Verify the title as 'Duplicate Lead'
		String title1 = driver.getTitle();
		String title="Duplicate Lead | opentaps CRM";
		
		if(title1==title)
			System.out.println("The title of the web page is "+title);
		else
			System.out.println("Title of the web page is "+title1);
		
	//15.	Click Create Lead
		driver.findElementByXPath("//input[@name='submitButton']").click();
		Thread.sleep(5000);
		
	//16.	Confirm the duplicated lead name is same as captured name
		String duplicateFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("The First name of the lead created is "+firsttext);
		if (firsttext .equals(duplicateFirstName)) {
			System.out.println("Duplicate lead name is same as captured lead name");
		}
		else {
			System.out.println("Duplicate lead name is different");
		}	
	//17.	Close the browser (Do not log out)
			driver.close();
			Thread.sleep(2000);
			System.out.println("The browser is closed successfully");
	}
	
}
