import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium13Hover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/hovers");

		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebElement photu = driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
		act.moveToElement(photu).perform();
	
		// h5[normalize-space()='name: user1']
		WebElement caption = driver.findElement(By.xpath("//h5[normalize-space()='name: user1']"));
		if (caption.isDisplayed()) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");
		}

	}

}
