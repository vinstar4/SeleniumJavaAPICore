import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumCourseManagementWorkflow {
	// Automates an end-to-end course management workflow using Selenium WebDriver, including login,
	// course creation with validations, verification, deletion, logout, and basic exception handling.

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		WebElement manageElement = driver.findElement(By.xpath("//span[normalize-space()='Manage']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(manageElement).perform();
		driver.findElement(By.partialLinkText("Manage Courses")).click();
		// button[normalize-space()='Add New Course']
		driver.findElement(By.xpath("//button[normalize-space()='Add New Course']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebElement saveBtn = driver.findElement(By.xpath("//button[@class='action-btn']"));
		saveBtn.click();
		// h2[@class='errorMessage']
		WebElement errorMsg = driver.findElement(By.xpath("//h2[@class='errorMessage']"));
		if (errorMsg.getText().toLowerCase().contains("please fill all the fields")) {
			System.out.println("Validation 1 - point no 5 passed");
		} else {
			System.out.println("Validation 1 - point no 5 failed");
		}
		// "C:\Users\vinay\Desktop\excel thumbnail.jpg"
		driver.findElement(By.xpath("//input[@id='thumbnail']"))
				.sendKeys("C:\\Users\\vinay\\Desktop\\excel thumbnail.jpg");
		// input[@id='name']
		// textarea[@id='description']
		// input[@id='instructorNameId']
		// input[@id='price']
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Excel for Beginers 2");

		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("continuation of efb1");

		driver.findElement(By.xpath("//input[@id='instructorNameId']")).sendKeys("Jane Doe");

		WebElement price = driver.findElement(By.xpath("//input[@id='price']"));
		price.clear();
		price.sendKeys("500");
		// input[@name='startDate']
		// input[@name='endDate']
		driver.findElement(By.xpath("//input[@name='startDate']")).click();
		WebElement sd = driver.findElement(By.xpath("//div[@role='listbox']//div[text()='28']"));
		sd.click();
		// sd.clear();
		// sd.sendKeys("06/27/2026");
		// div[contains(@class,'title modal-title h4')]

		driver.findElement(By.xpath("//input[@name='endDate']")).click();
		// button[@aria-label='Next Month']
		driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();

		WebElement ed = driver.findElement(By.xpath("//div[@role='listbox']//div[text()='29']"));
		// ed.clear();
		// ed.sendKeys("07/27/2026");
		ed.click();

		// div[normalize-space()='Select Category']
		driver.findElement(By.xpath("//div[normalize-space()='Select Category']")).click();
		// button[normalize-space()='JavaScript']
		driver.findElement(By.xpath("//button[normalize-space()='JavaScript']")).click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		// button[normalize-space()='Save']
		saveBtn.click();

		// verify saved success below
		// td[normalize-space()='Excel for Beginers 2']

		try {
			WebElement savedCourse = driver.findElement(By.xpath("//td[normalize-space()='Excel for Beginers 2']"));
			System.out.println("validation 2, point 9.1 passed course is saved successfully");
		} catch (Exception e) {
			System.out.println("validation 2, point 9.1 failed course is NOT saved successfully");
		}

		// td[normalize-space()='Excel for Beginers 2']/following::img[1]
		try {
			WebElement savedCourse2 = driver
					.findElement(By.xpath("//td[normalize-space()='Excel for Beginers 2']/following::img[1]"));
			if (savedCourse2.getAttribute("alt").toLowerCase().equals("activate")) {
				System.out.println("validation 2, point 9.2 passed course is active successfully");
			}
		} catch (Exception e) {
			System.out.println("validation 2, point 9.2 failed course is NOT active successfully");
		}

		// button[@class='action-btn delete-btn']
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='action-btn delete-btn']")).click();
		Thread.sleep(1000);

		try {
			WebElement savedCourse = driver.findElement(By.xpath("//td[normalize-space()='Excel for Beginers 2']"));
			System.out.println("validation 3, point 10 failed");
		} catch (Exception e) {
			System.out.println("validation 3, point 10 passed");
		}

		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).click();
		System.out.println("Signed out successfully");
		driver.quit();

	}

}
