import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium24BrokenImages {
	/*1. Locate all images on the page
2. For each image, check if it is broken
*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://bstackdemo.com/
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		List<WebElement> lst = driver.findElements(By.tagName("img"));
		for (WebElement img : lst){
			String imgURL = img.getAttribute("src");
			if(isImageLoaded(driver,img)){
				System.out.println("Image valid->"+imgURL);
			}
			else {
				System.out.println("Image broken->"+imgURL);
			}
			
			
		}
		
		
		
			
			
		
		
		
		
		
			

	}

	private static boolean isImageLoaded(WebDriver driver, WebElement img) {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (Boolean) js.executeScript("return arguments[0].complete && arguments[0].naturalWidth>0 ;", img);
	}


}
