import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class SeleniumDemoForBrokenLinks {

	public static void main(String[] args) {

		// Create WebDriver instance and open the website.
		// System.setProperty("webdriver.chrome.driver",
		// "./src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bstackdemo.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links found: " + links.size());

		for (WebElement link : links) {

			// Step 7: Get the href attribute (actual URL)
			String url = link.getAttribute("href");

			// Some links may not have href or may be empty
			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty or null, skipping...");
				continue;
			}

			try {
				// Step 8: Create URL object
				URL linkURL = new URL(url);

				// Step 9: Open connection
				HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();

				// Step 10: Set request method as HEAD (faster than GET)
				connection.setRequestMethod("HEAD");

				// Step 11: Connect to the URL
				connection.connect();

				// Step 12: Get response code
				int responseCode = connection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println(url + " ---> BROKEN (Response Code: " + responseCode + ")");
				} else {
					System.out.println(url + " ---> VALID (Response Code: " + responseCode + ")");
				}

			} catch (Exception e) {
				// If any exception occurs, consider it broken
				System.out.println(url + " ---> ERROR OCCURRED");
			}
		}

		// Close the browser session
		driver.quit();
	}

}
