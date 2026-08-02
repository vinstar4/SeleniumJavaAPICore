import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1LoginFlow {

	public static void main(String[] args) {

		// 1. Launch browser
		WebDriver driver = new ChromeDriver();

		try {
			// 2. Open URL
			driver.get("https://the-internet.herokuapp.com/login");
			driver.manage().window().maximize();

			// 3. Enter username
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("tomsmith");

			// 4. Enter password
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("SuperSecretPassword!");

			// 5. Click login button
			WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
			loginBtn.click();

			// 6. Capture success message
			WebElement message = driver.findElement(By.id("flash"));
			String text = message.getText();

			// 7. Validate result
			if (text.contains("You logged into a secure area!")) {
				System.out.println("TEST PASSED");
			} else {
				System.out.println("TEST FAILED");
			}

		} finally {
			// 8. Close browser
			driver.quit();
		}
	}

}
