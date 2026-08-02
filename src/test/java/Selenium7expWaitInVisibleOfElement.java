import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium7expWaitInVisibleOfElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Task: 1. Click Remove 2. Wait until checkbox disappears Validation: •
		 * Checkbox is no longer present in DOM
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();
		By cb = By.xpath("//input[@type='checkbox']");
		WebElement btn = driver.findElement(By.xpath("//button[normalize-space()='Remove']"));
		btn.click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		Boolean check = w.until(ExpectedConditions.invisibilityOfElementLocated(cb));
		if (check) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");
		}
		driver.quit();

	}

}
