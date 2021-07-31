package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContacts {

	public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
	// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(2000);
		
	// 3. Click on Login Button using Class Locator
		driver.findElementByClassName("decorativeSubmit").click();
		Thread.sleep(5000);
		
	// 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(5000);
		
	// 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(5000);
		
	// 6. Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		Thread.sleep(5000);
		
	// 7. Enter FirstName Field Using id Locator
		driver.findElementById("firstNameField").sendKeys("Test FName");
		
	// 8. Enter LastName Field Using id Locator
		driver.findElementById("lastNameField").sendKeys("Test LName");
		
	// 9. Enter FirstName(Local) Field Using id Locator
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("Test Local FName");
		
	// 10. Enter LastName(Local) Field Using id Locator
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("Test Local LName");
		
	// 11. Enter Department Field Using any Locator of Your Choice
		driver.findElementByName("departmentName").sendKeys("QA");
	
	// 12. Enter Description Field Using any Locator of your choice 
		driver.findElementByXPath("//textarea[@class='inputBox']").sendKeys("This is a Test Description");
		
	// 13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElementByName("primaryEmail").sendKeys("testAruna@gmail.com");
	
	// 14. Select State/Province as NewYork Using Visible Text
		WebElement state = driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select stateDropDown=new Select(state);
		stateDropDown.selectByVisibleText("New York");
	
	//15. Click on Create Contact
		driver.findElementByXPath("//input[@name='submitButton']").click();
		Thread.sleep(5000);
		
	//16. Click on edit button 
		driver.findElementByLinkText("Edit").click();
		Thread.sleep(5000);
		
	//17. Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
	
	//18. Fill ImportantNote Field with Any text
		driver.findElementById("updateContactForm_importantNote").sendKeys("Important Notice");
		
	//19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		Thread.sleep(5000);
		
	//20. Get the Title of Resulting Page.
		String title1 = driver.getTitle();
		String title="View Contact | opentaps CRM";
		
		if(title1==title)
			System.out.println("The title of the web page is "+title);
		else
			System.out.println("Title of the web page is "+title1);
		
	}

}
