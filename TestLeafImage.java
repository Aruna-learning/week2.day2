package week2.day2;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeafImage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
//Click on image to go to home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.findElementByXPath("//img[@src='images/image.png']").click();
		
//To find whether image is broken
		WebElement findElementByXPath = driver.findElementByXPath("//img[@src='../images/abcd.jpg']");
		String attribute1 = findElementByXPath.getAttribute("naturalWidth");
		if(attribute1.equals("0"))
		System.out.println("The image is broken");
		else
		System.out.println("Image is not broken");
		
//To click the image using keyboard
		WebElement x1 = driver.findElementByXPath("(//label[@for='position'])[2]/following-sibling::img");
		Thread.sleep(5000);
		Actions actions=new Actions(driver);
		actions.doubleClick(x1).build().perform();
	
		
		
		
	}

	

}
