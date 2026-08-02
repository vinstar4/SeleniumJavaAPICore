import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Selenium9Fluentwait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * URL: https://the-internet.herokuapp.com/dynamic_controls Task: 1. Click
		 * Enable 2. Use FluentWait: o Polling interval: 250 ms o Ignore:
		 * NoSuchElementException 3. Wait until input field is enabled Validation: •
		 * Input field becomes enabled
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();
		By enableBtn = By.xpath("//button[normalize-space()='Enable']");
		WebElement btn = driver.findElement(enableBtn);
		btn.click();
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
		WebElement ele = wait.until(d -> {
			WebElement element2 = d.findElement(By.xpath("//input[@type='text']"));
			return element2.isEnabled() ? element2 : null;

		});

		if (ele.isEnabled()) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");
		}
		driver.quit();

	}

}
