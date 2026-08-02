import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium12windowswitching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*code to demnonstrate switching tabs and windows */
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");

		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Click Here")).click();

		String parent = driver.getWindowHandle();

		for (String w : driver.getWindowHandles()) {

			if (!w.equals(parent)) {
				driver.switchTo().window(w);
				break;
			}
		}

		// driver.findElement(By.xpath("//h3[normalize-space()='New
		// Window']")).getText()
		String s = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
		System.out.println(s);
		driver.close();
		driver.switchTo().window(parent);
		driver.quit();

	}

}
