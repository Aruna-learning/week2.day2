package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadSelect {

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
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Aruna1");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		
		WebElement dd1=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drpDwn1=new Select(dd1);
		drpDwn1.selectByValue("LEAD_EXISTCUST");
		
		WebElement dd2=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drpDwn2=new Select(dd2);
		drpDwn2.selectByVisibleText("Automobile");
		
		WebElement dd3=driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select drpDwn3=new Select(dd3);
		drpDwn3.selectByIndex(2);
		
		WebElement dd4=driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select drpDwn4=new Select(dd4);
		drpDwn4.selectByValue("DZD");
		
		WebElement dd5=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select drpDwn5=new Select(dd5);
		drpDwn5.selectByVisibleText("S-Corporation");
		
		
		WebElement dd6=driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select drpDwn6=new Select(dd6);
		drpDwn6.selectByVisibleText("India");
		
		WebElement dd7=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select drpDwn7=new Select(dd7);
		drpDwn7.selectByIndex(4);
		
		
		//driver.findElement(By.className("smallSubmit")).click();
		


	}

}
