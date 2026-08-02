import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium17FileUpload {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            // Open the application
            driver.get("https://the-internet.herokuapp.com/upload");
            driver.manage().window().maximize();

            // File path
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\sample.txt";

            // Upload file
            driver.findElement(By.id("file-upload")).sendKeys(filePath);

            // Click Upload button
            driver.findElement(By.id("file-submit")).click();

            // Validation
            String uploadedFileName = driver.findElement(By.id("uploaded-files")).getText();
            Assert.assertEquals(uploadedFileName, "sample.txt");

            System.out.println("File uploaded successfully!");
            System.out.println("Uploaded File: " + uploadedFileName);

        } finally {
            driver.quit();
        }
    }
}