import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4Contactusform {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * URL: https://automationexercise.com/contact_us Task: 1. Enter: o Name o Email
		 * o Subject o Message 2. Submit the form
		 */
		WebDriver driver = new ChromeDriver();
		try {

			driver.get("https://automationexercise.com/contact_us");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// input[@placeholder='Name']
			// input[@placeholder='Email']
			// input[@placeholder='Subject']
			// textarea[@id='message']
			// input[@name='submit']

			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rahul@rahul.com");
			driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("trial");
			driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("subject");
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			driver.switchTo().alert().accept();

			WebElement successMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));

			if (successMsg.isDisplayed()) {
				System.out.println("TEST PASSED");
			} else {
				System.out.println("TEST FAILED");
			}

		}

		finally {
			driver.quit();
		}

	}

}
