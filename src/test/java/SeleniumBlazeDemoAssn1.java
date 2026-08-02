

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBlazeDemoAssn1 {
	// Automates an end-to-end flight booking workflow on BlazeDemo using Selenium WebDriver,
	// including flight search, booking detail validation, form submission, and confirmation page verification.

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		// select[@name='fromPort']
		// select[@name='toPort']
		// input[@value='Find Flights']
		WebElement from = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select s = new Select(from);
		s.selectByVisibleText("Boston");
		WebElement to = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select s2 = new Select(to);
		s2.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[normalize-space()='Lufthansa']/parent::tr/td[1]/input")).click();
		String current_url = driver.getCurrentUrl();
		Thread.sleep(500);
		String title = driver.getTitle();
		if (current_url.toLowerCase().contains("purchase") && title.toLowerCase().contains("purchase")) {
			System.out.println("Verification 1 and 2 PASSED:-Title and URL contains purchase");
		} else {
			System.out.println("Verification 1 and 2 FAILED:-Title and URL contains purchase");
		}

		String airline = driver.findElement(By.xpath("//h2/following-sibling::p[1]")).getText();
		if (airline.equalsIgnoreCase("Airline: United")) {
			System.out.println("Airline verification suceessful");
		} else {
			System.out.println("Airline verification failed");
		}

		String fno = driver.findElement(By.xpath("//h2/following-sibling::p[2]")).getText();
		if (fno.equalsIgnoreCase("Flight Number: UA954")) {
			System.out.println("Flight no verification suceessful");
		} else {
			System.out.println("Flight no verification failed");
		}

		String price = driver.findElement(By.xpath("//h2/following-sibling::p[3]")).getText();
		if (price.equalsIgnoreCase("Price: 400")) {
			System.out.println("price verification suceessful");
		} else {
			System.out.println("price verification failed");
		}

		String fees = driver.findElement(By.xpath("//h2/following-sibling::p[4]")).getText();
		String[] fees_array = fees.split("\\s+");
		double feeDouble = Double.valueOf(fees_array[fees_array.length - 1]);
		if (feeDouble == 514.76) {
			System.out.println("Fees validation passed");
		}

		driver.findElement(By.id("inputName")).sendKeys("Playright JS");
		driver.findElement(By.id("address")).sendKeys("BLR");
		driver.findElement(By.id("city")).sendKeys("BLR city");
		driver.findElement(By.id("state")).sendKeys("Karnataka");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		WebElement card = driver.findElement(By.id("cardType"));
		Select s3 = new Select(card);
		s3.selectByValue("amex");
		driver.findElement(By.id("creditCardNumber")).sendKeys("1234567890123456");
		// creditCardYear
		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys("2025");
		// nameOnCard
		driver.findElement(By.id("nameOnCard")).sendKeys("Playwright by Microsoft");

		driver.findElement(By.id("rememberMe")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(500);

		current_url = driver.getCurrentUrl();
		Thread.sleep(500);
		title = driver.getTitle();
		if (current_url.toLowerCase().contains("confirmation") && title.toLowerCase().contains("confirmation")) {
			System.out.println("Verification 7 and 8 PASSED:-Title and URL contains confirmation");
		} else {
			System.out.println("Verification 7 and 8 FAILED:-Title and URL contains confirmation");
		}

		String oid = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		if (oid != null && !oid.isBlank()) {
			System.out.println("oid validation passed:- " + oid);
		}

		driver.quit();
		System.out.println("Thank you");

	}
}
