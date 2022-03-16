package intro;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoAmazon {
	
	public static void main(String [] args) {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arun.y\\chromeDriver\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://amazon.in");
			driver.manage().window().maximize();

			
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Alexa");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		driver.findElement(By.partialLinkText("Echo Dot")).click();
		
		// Now as echo dot is opened in the new tab so we need to shift the control to the new tab
		
		Set<String> handles = driver.getWindowHandles();
		
		String current = driver.getWindowHandle();
		
		
		for(String actual : handles) {
			if(!actual.equalsIgnoreCase(current)) {
				driver.switchTo().window(actual);
				break;
			}
		}
		
		
	   System.out.println(driver.getTitle());
	   
	   String mrp = driver.findElement(By.cssSelector("#corePrice_desktop > div > table > tbody > tr:nth-child(1) > td.a-span12.a-color-secondary.a-size-base > span.a-price.a-text-price.a-size-base > span:nth-child(2)")).getText();
			
       String deal = driver.findElement(By.cssSelector("#corePrice_desktop > div > table > tbody > tr:nth-child(2) > td.a-span12 > span.a-price.a-text-price.a-size-medium.apexPriceToPay > span:nth-child(2)")).getText();
		 
       System.out.println(deal +"<><>"+ mrp);
       
       driver.quit();
       
	 } 

}
