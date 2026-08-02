import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium23Basic {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By input = By.id("target");
        By result = By.id("result");

        // Focus and type normal text
       WebElement tBox = wait.until(ExpectedConditions.elementToBeClickable(input));
        tBox.click();
        tBox.sendKeys("abc");

        // Wait for last key (c) to be reflected
        wait.until(ExpectedConditions.textToBe(result, "You entered: C"));

        String output = driver.findElement(result).getText();
        System.out.println(output);

        driver.quit();
    }
}