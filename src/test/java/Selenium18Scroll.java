import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium18Scroll {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/infinite_scroll");
            driver.manage().window().maximize();

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll 3 times
            for (int i = 0; i < 3; i++) {

                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

                // Wait for new content to load
                Thread.sleep(2000);
            }

            System.out.println("Scrolling done");

        } finally {
            driver.quit();
        }
    }
}