import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2CheckboxSelection {
	/*
	 * 2. Checkboxes Selection URL: https://the-internet.herokuapp.com/checkboxes
	 * Task: 1. Select checkbox 1 2. Unselect checkbox 2 Validation: • Checkbox 1 →
	 * selected • Checkbox 2 → not selected
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		try {

			driver.get("https://the-internet.herokuapp.com/checkboxes");
			driver.manage().window().maximize();
			WebElement cb1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			WebElement cb2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			if (!cb1.isSelected()) {
				cb1.click();
			}

			if (cb2.isSelected()) {
				cb2.click();
			}

			if (cb1.isSelected() && !cb2.isSelected()) {
				System.out.println("pass");
			} else {
				System.out.println("fail");

			}

		} finally {
			driver.quit();
		}

	}

}
