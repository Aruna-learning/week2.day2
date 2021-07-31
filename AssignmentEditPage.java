package week2.day2;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentEditPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	//Launch leaftaps edit page
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElementById("email").sendKeys("saruna27sampath@gmail.com");
		//WebElement newText= driver.findElementByXPath("//input[@value='Append ']");
		WebElement newText=driver.findElementByXPath("//input[@value='Append ']");
		Thread.sleep(5000);
		newText.sendKeys("New Text to the field",Keys.TAB);
		Thread.sleep(5000);
		String textDefault = driver.findElementByXPath("//input[@value='TestLeaf']").getAttribute("value");
		System.out.println("The default text appearing is :"+textDefault);
		WebElement clearText = driver.findElementByXPath("//input[@value='Clear me!!']");
		clearText.clear();
				
		//boolean enabled = driver.findElement(By.id(("(//input[@type='text'])[5]")).isEnabled();
		boolean enabled = driver.findElementByXPath("(//input[@type='text'])[5]").isEnabled();
		System.out.println(enabled);
		
		
		
	}

}
