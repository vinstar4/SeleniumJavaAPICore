import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium16TableFinal {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://the-internet.herokuapp.com/tables");
			driver.manage().window().maximize();

			// Get email where Last Name = Smith
			String email = driver.findElement(By.xpath("//tr[td[text()='Smith']]/td[3]")).getText();
			
			//td[text()='Smith']/parent::tr/td[3]
			//this is also superb

			System.out.println("Email: " + email);

			// Validation
			if (email.equals("jsmith@gmail.com")) {
				System.out.println("TEST PASSED");
			} else {
				System.out.println("TEST FAILED");
			}

		} finally {
			driver.quit();
		}
	}
}