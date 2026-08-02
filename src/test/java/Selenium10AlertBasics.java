import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium10AlertBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * URL: https://the-internet.herokuapp.com/javascript_alerts Task: 1. Click JS
		 * Alert → Accept 2. Click JS Confirm → Dismiss 3. Click JS Prompt → Enter Hello
		 * and accept Validation: • Result text updates correctly for each action
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert a = driver.switchTo().alert();
		a.accept();

		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		a = driver.switchTo().alert();
		a.dismiss();

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		a = driver.switchTo().alert();
		a.sendKeys("Hello!");
		a.accept();

		// p[@id='result']
		if (driver.findElement(By.xpath("//p[@id='result']")).getText().equals("You entered: Hello!")) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");
		}

		driver.quit();

	}

}
