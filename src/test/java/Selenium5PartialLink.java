import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium5PartialLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 5. Partial Link Text Click URL: https://the-internet.herokuapp.com Task: 1.
		 * Locate link using partial text: "A/B" 2. Click the link Validation: •
		 * Navigates to /abtest page
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.partialLinkText("A/B")).click();

		if (driver.getCurrentUrl().contains("/abtest")) {
			System.out.print("TEST PASSED");
		} else {
			System.out.print("TEST FAILED");
		}

		driver.quit();

	}

}
