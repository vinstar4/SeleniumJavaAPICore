import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium22ExplWait {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Locate the input field (initially disabled)
        WebElement inputField = driver.findElement(By.cssSelector("#input-example input"));

        // 2. Click Enable button
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example button"));
        enableButton.click();

        // 3. Wait until input field becomes enabled
        wait.until(ExpectedConditions.elementToBeClickable(inputField));

        // 4. Verify conditions
        boolean isEnabled = inputField.isEnabled();
        boolean isDisplayed = inputField.isDisplayed();

        System.out.println("Input Field Enabled: " + isEnabled);
        System.out.println("Input Field Displayed: " + isDisplayed);

        if (isEnabled && isDisplayed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}