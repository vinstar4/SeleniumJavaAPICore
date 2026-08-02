import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium20ShadowDOM {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            // Step 0: Open website
            driver.get("https://books-pwakit.appspot.com/");
            driver.manage().window().maximize();

            // ---------------------------------------------------
            // Step 1: Locate the SHADOW HOST
            // ---------------------------------------------------
            // This is a normal element in DOM
            // Inside this, shadow root exists
            WebElement host = driver.findElement(By.tagName("book-app"));

            // ---------------------------------------------------
            // Step 2: Access SHADOW ROOT
            // ---------------------------------------------------
            // This gives access to hidden DOM inside host
            SearchContext shadowRoot = host.getShadowRoot();

            // ---------------------------------------------------
            // Step 3: Locate element INSIDE shadow DOM
            // ---------------------------------------------------
            // Now we search inside shadowRoot, NOT driver
            WebElement inputBox = shadowRoot.findElement(By.cssSelector("input"));

            // ---------------------------------------------------
            // Step 4: Perform action
            // ---------------------------------------------------
            inputBox.sendKeys("Harry Potter");

            System.out.println("Typed inside shadow DOM");

            // ---------------------------------------------------
            // Optional Validation
            // ---------------------------------------------------
            String value = inputBox.getAttribute("value");

            if (value.contains("Harry Potter")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

        } finally {
            driver.quit();
        }
    }
}