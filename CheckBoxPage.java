package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		
//Check the languages known - click Java and SQL which is 1 and 3
		driver.findElementByXPath("//input[@type='checkbox']").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[3]").click();
		
//Confirm whether Selenium checkbox is checked
		boolean selected = driver.findElementByXPath("(//input[@type='checkbox'])[6]").isSelected();
		if (selected==true)
		System.out.println("Confirmed: The Selenium checkbox is already checked during page load");
		else
		{
			System.out.println("The Selenium checkbox is not selected before and I have checked now");
			driver.findElementByXPath("(//input[@type='checkbox'])[6]").click();
		}	
//Deselect the selected checkbox
		boolean selected1 = driver.findElementByXPath("(//input[@type='checkbox'])[8]").isSelected();
		if (selected1==true)
		{
		System.out.println("The 'I am selected checkbox' was already checked and now deselected");
		driver.findElementByXPath("(//input[@type='checkbox'])[8]").click();
		}
		else
		{
			System.out.println("The 'Not selected' checkbox is selected and then deselected ");
			driver.findElementByXPath("(//input[@type='checkbox'])[7]").click();
		}
			
//Selecting all the checkbox options
		driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[12]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[13]")).click();
	}

}
