import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOrangeHRMAssn1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// input[@placeholder='Username']//input[@placeholder='Password']
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(750);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		// button[@type='submit']
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// span[normalize-space()='Admin']
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		Thread.sleep(1000);
		// button[normalize-space()='Add']
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		// div[@class='oxd-select-text oxd-select-text--active'][1]
		// div[@class='oxd-select-text oxd-select-text--active'][2]
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][1]")).click();
		// div[@role='listbox']/div[normalize-space()='Admin']
		driver.findElement(By.xpath("//div[@role='listbox']/div[normalize-space()='Admin']")).click();
		// input[@placeholder='Type for hints...']
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("a");
		Thread.sleep(2000);
		// span[contains(text(),'Ranga')]
		driver.findElement(By.xpath("//span[contains(text(),'Ranga')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]")).click();
		// span[normalize-space()='Enabled']
		driver.findElement(By.xpath("//span[normalize-space()='Enabled']")).click();
		// (//input[@class='oxd-input oxd-input--active'])[2]
		// (//input[@type='password'])[1]
		String un = "username_" + System.currentTimeMillis();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(un);
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Demo@12345678");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Demo@12345678");
		// button[@type='submit']
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("User created successfully");
		driver.quit();

	}

}
