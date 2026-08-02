import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium11frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*code to demonstrate switching between frames*/
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");

		driver.manage().window().maximize();
		driver.switchTo().frame("frame-top");
		WebElement lFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(lFrame);
		WebElement lframebody = driver.findElement(By.tagName("body"));
		System.out.println(lframebody.getText());
		String leftText = lframebody.getText();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame-bottom");
		String bottomText = driver.findElement(By.tagName("body")).getText();
		System.out.println(bottomText);

		if (leftText.contains("LEFT") && bottomText.contains("BOTTOM")) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");
		}

		driver.quit();

	}

}
