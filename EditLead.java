package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	//http://leaftaps.com/opentaps/control/main
		
	// 1. Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
	
	// 2. Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
				
	// 3. Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(2000);
		
	// 4. Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		Thread.sleep(5000);
		
 	// 5. Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(5000);
		
	// 6. Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(5000);
		
	// 7. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);
		
	// 8. Enter first name
		driver.findElement(By.xpath("(//input[@type='text' and @name='firstName'])[3]")).sendKeys("babu");
		
	// 9. Click Find leads button
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(5000);
		
	// 10. Click on first resulting lead
		driver.findElement(
				By.xpath("//td[@class= 'x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a[1]")).click();
		Thread.sleep(5000);
		
	// 11. Verify title of the page
		String title1 = driver.getTitle();
		String title="View Lead | opentaps CRM";
		
		if(title1==title)
			System.out.println("The title of the web page is "+title);
		else
			System.out.println("Title of the web page is "+title1);
		
	// 12. Click Edit
		driver.findElementByLinkText("Edit").click();
		Thread.sleep(5000);
		
	// 13. Change the company name
		driver.findElementById("updateLeadForm_companyName").sendKeys("Changed");
		String changed="Changed";
	// 14. Click Update
		driver.findElementByClassName("smallSubmit").click();
		Thread.sleep(5000);
		
	// 15. Confirm the changed name appears
		String textchanged = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println("The initial title appearing was: "+changed);
		System.out.println("The updated title is: "+textchanged);
		if(textchanged.contains(changed))
			System.out.println("Therefore the company name is successfully changed");
		else
			System.out.println("The company name is not successfully changed");
		Thread.sleep(3000);
	// 16. Close the browser (Do not log out)
		driver.close();
		Thread.sleep(2000);
		System.out.println("Browser is closed successfully");
	}

}
