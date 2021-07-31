package week2.day2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignHyperLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		// Go to homepage
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();

		// Find me without cliking on me
		String attribute = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");
		System.out.println("Without clicking one me, I am supposed to go here: " + attribute);

		// Verify whether I am broken
		WebElement findElement1 = driver.findElement(By.linkText("Verify am I broken?"));
		String hreflink1 = findElement1.getAttribute("href");
		System.out.println("The link for verifying whether its broken is " + hreflink1);
		findElement1.click();
		String errorTitle = "HTTP Status 404 – Not Found";
		String actualTitle = driver.getTitle();
		if (errorTitle.equals(actualTitle)) {
			System.out.println("Error Page is displayed");
		} else {
			System.out.println("Landed Page is displayed correctly");
		}
//Going back to homepage again
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		// Go to homepage
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		
//finding number of links in this page
		List<WebElement> findElementByTagName = driver.findElements(By.tagName("a"));
		System.out.println("The links found in this web page is "+findElementByTagName.size());
	}

}
