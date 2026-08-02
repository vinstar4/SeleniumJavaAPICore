import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium8Presence {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 8. Wait for Presence in DOM URL:
		 * https://the-internet.herokuapp.com/dynamic_loading/2 Task: 1. Click Start 2.
		 * Wait for element to be present in DOM Validation: • Text Hello World! is
		 * displayed
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().window().maximize();
		By helloWorld = By.xpath("//h4[normalize-space()='Hello World!']");
		By startButton = By.xpath("//button[normalize-space()='Start']");
		WebElement btn = driver.findElement(startButton);
		btn.click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement check = w.until(ExpectedConditions.presenceOfElementLocated(helloWorld));
		if (check.getText().equals("Hello World!")) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");
		}
		driver.quit();

	}

}
