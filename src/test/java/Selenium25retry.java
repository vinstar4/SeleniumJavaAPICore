import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium25retry {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			// Open URL
			driver.get("https://the-internet.herokuapp.com/notification_message_rendered");

			String message = "";
			int maxAttempts = 10;
			boolean success = false;

			for (int i = 0; i < maxAttempts; i++) {

				// Click the link
				driver.findElement(By.linkText("Click here")).click();

				// Capture message
				WebElement msgElement = driver.findElement(By.id("flash"));
				message = msgElement.getText().replace("×", "") // remove close symbol
						.trim();

				System.out.println("Attempt " + (i + 1) + ": " + message);

				// Check success condition
				if (message.equals("Action successful")) {
					success = true;
					break;
				}
			}

			// Final validation
			if (success) {
				System.out.println("Test Passed: Success message appeared");
			} else {
				System.out.println("Test Failed: Success message not found in " + maxAttempts + " attempts");
			}

		} finally {
			// Close browser
			driver.quit();
		}
	}
}