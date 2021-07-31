package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
	//Select drop down value by index
		WebElement dd1 = driver.findElement(By.id("dropdown1"));
		Select drpdown1=new Select(dd1);
		drpdown1.selectByIndex(1);
	//Select drop down value by text
		WebElement dd2= driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select drpdown2=new Select(dd2);
		drpdown2.selectByVisibleText("Appium");
	//Select drop down value by value
		WebElement dd3 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select drpdown3=new Select(dd3);
		drpdown3.selectByValue("2");
	//get the drop down options 
		WebElement dd4 = driver.findElementByXPath("//select[@class='dropdown']");
		Select drpdown4=new Select(dd4);
		int size = drpdown4.getOptions().size();
		System.out.println("The size of the dropdown is "+size);
	//using sendkeys to select drop down values
		driver.findElement(By.xpath("(//div[@class='example'])[5]/select")).sendKeys("Loadrunner");
		
		WebElement dd5 = driver.findElementByXPath("(//div[@class='example'])[6]/select");
				
		Select drpdown5 = new Select(dd5);
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL)
		.click(drpdown5.getOptions().get(2))
		.click(drpdown5.getOptions().get(3))
		.click(drpdown5.getOptions().get(4))
		.keyUp(Keys.CONTROL);

		builder.build().perform();
			
		
	}

}
