package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leafground.com/pages/radio.html");
//Click yes radio button for first question
	driver.findElement(By.id("yes")).click();
//Identify the default clicked drop down
	String text1 = driver.findElementByXPath("//label[@for='Checked']").getText();
	System.out.println(text1);
	String text2 = driver.findElementByXPath("//label[@for='Unchecked']").getText();
	System.out.println(text2);
	boolean blank = text1.isBlank();
	if(blank != true)
		System.out.println("The selected radio button is "+text1);
	else
		System.out.println("The Selected radio button is "+text2);
//Select the age group if not enabled - for this assignment click radio button option 1
	
	WebElement enabledButton = driver.findElement(By.xpath("(//input[@type='radio'])[5]"));
	boolean enabled = enabledButton.isEnabled();
	if(enabled==false)
		System.out.println("The age group button 21 - 40 Years is enabled");
	else
	{
		System.out.println("The age group button 1 - 20 Years is disabled by default and I have clicked now");
		enabledButton.click();
		
	}
	}

}
