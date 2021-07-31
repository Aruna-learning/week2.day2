package week2.day2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignButtonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElementById("home").click();
		driver.findElementByXPath("//img[@alt='Buttons']").click();
		Point location = driver.findElementByXPath("//button[@id='position']").getLocation();
		System.out.println(location);
		String value = driver.findElementById("color").getCssValue("background-color");
		System.out.println(value);
		Dimension size = driver.findElementById("size").getSize();
		System.out.println(size);
	}

}

