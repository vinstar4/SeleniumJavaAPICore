import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium6wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 6. Wait for Visibility URL:
		 * https://the-internet.herokuapp.com/dynamic_loading/1 Task: 1. Click Start 2.
		 * Wait for “Hello World!” text to become visible Validation: • Text Hello
		 * World! is displayed
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		By hello = By.xpath("//h4[normalize-space()='Hello World!']");
		WebElement x = w.until(ExpectedConditions.visibilityOfElementLocated(hello));
		System.out.print(x.isDisplayed());
		if (x.isDisplayed()) {
			System.out.print("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");

		}
		driver.quit();

	}

}
