
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;


public class Selenium14DragDrop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://the-internet.herokuapp.com/drag_and_drop");
			driver.manage().window().maximize();
			Actions act = new Actions(driver);


			WebElement source = driver.findElement(By.id("column-a"));
			WebElement target = driver.findElement(By.id("column-b"));

			act.dragAndDrop(source, target).perform();

			// Validation
			String text = driver.findElement(By.id("column-a")).getText();

			if (text.equals("B")) {
				System.out.println("TEST PASSED");
			} else {
				System.out.println("TEST FAILED");
			}

		} finally {
			driver.quit();
		}
	}
}