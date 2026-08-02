import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium19Cookies {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");
            driver.manage().window().maximize();

            // 1. Add cookie
            Cookie cookie = new Cookie("test", "123");
            //Cookie cookie = new Cookie("test","123");
            driver.manage().addCookie(cookie);
            //driver.manage().addCookie(cookie);

            // 2. Refresh page
            driver.navigate().refresh();

            // Verify cookie added
            Cookie getCookie = driver.manage().getCookieNamed("test");
           
            System.out.println("Cookie Value: " + getCookie.getValue());
            

            // 3. Delete all cookies
            driver.manage().deleteAllCookies();

            // Verify deletion
            if (driver.manage().getCookies().isEmpty()) {
                System.out.println("All cookies deleted - TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

        } finally {
            driver.quit();
        }
    }
}