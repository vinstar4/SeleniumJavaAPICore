import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium15RightClick {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://the-internet.herokuapp.com/context_menu");
			driver.manage().window().maximize();

			// Locate the box
			WebElement box = driver.findElement(By.id("hot-spot"));

			// Right click using Actions
			Actions act = new Actions(driver);
			act.contextClick(box).perform();

			// Handle alert
			Alert alert = driver.switchTo().alert();

			String text = alert.getText();
			System.out.println("Alert Text: " + text);

			// Validation
			if (text.equals("You selected a context menu")) {
				System.out.println("TEST PASSED");
			} else {
				System.out.println("TEST FAILED");
			}

			alert.accept();

		} finally {
			driver.quit();
		}
	}

}
