package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadsXpath {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.manage().window().maximize();
			
			WebElement webUserName=driver.findElement(By.id("username"));
			webUserName.sendKeys("demosalesmanager");
			
			WebElement webPassWord=driver.findElement(By.id("password"));
			webPassWord.sendKeys("crmsfa");
			
			driver.findElement(By.className("decorativeSubmit")).click();
			//Verify the title to check
			String orgTitle="Leaftaps - TestLeaf Automation Platform";
			String title=driver.getTitle();
			
			if (orgTitle.equals(title)) 
				System.out.println("Page landed up correctly");
				else
					System.out.println("Page not loaded correctly");
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			//driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
			driver.findElement(By.xpath("//input[@id=createLeadForm_companyName]")).sendKeys("TestLeaf");
					
			//driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Aruna");
			//driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
			
			//driver.findElement(By.className("smallSubmit")).click();
			

	}

}
