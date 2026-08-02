import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium3DropdownExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 3. Dropdown Selection URL: https://the-internet.herokuapp.com/dropdown Task:
		 * 1. Select Option 1 using visible text 2. Select Option 2 using value 3.
		 * Select Option 1 using index Validation: • Correct option is selected each
		 * time
		 */
		WebDriver driver = new ChromeDriver();
		try {

			driver.get("https://the-internet.herokuapp.com/dropdown");
			WebElement dd = driver.findElement(By.xpath("//select[@id='dropdown']"));
			Select s = new Select(dd);

			System.out.println(s.isMultiple());
			System.out.println(s.getOptions());
			s.selectByVisibleText("Option 1");
			System.out.println(s.getFirstSelectedOption().getText());

			s.selectByValue("2");
			System.out.println(s.getFirstSelectedOption().getText());

			s.selectByIndex(1);
			System.out.println(s.getFirstSelectedOption().getText());

			if ((s.getFirstSelectedOption().getText().contains("1"))) {
				System.out.println("test passed");
			} else {
				System.out.println("test failed");
			}

		}

		finally {
			driver.quit();
		}
	}

}
