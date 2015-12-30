package com.flightaware;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class tailing {
	public static void main(String[] args) {
		WebDriver driver;
		String baseUrl;
		String title = "n220ua";
		String firstFlightStatus = null;
		String firstArrivaleAirport = null;
		String firstDate = null;
		String secondFlightStatus = null;
		String secondArrivaleAirport = null;
		String secondDate = null;
		
		driver = new FirefoxDriver();
		baseUrl = "http://flightaware.com/live/flight/" + title;
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
		//driver.findElement(By.id("ident")).clear();
		//driver.findElement(By.id("ident")).sendKeys(title);
		//driver.findElement(By.cssSelector("button.unifiedtrack")).click();
		
		List<WebElement> flightStatus = driver.findElements(By
				.xpath("//div[@id='Body']/table[3]/tbody/tr[1]/td[7]"));
		for (WebElement resultItem : flightStatus) {
			firstFlightStatus = resultItem.getText();
			
		List<WebElement> date = driver.findElements(By
				.xpath("//div[@id='Body']/table[3]/tbody/tr[1]/td[1]"));
		for (WebElement resultItem2 : date) {
				firstDate = resultItem2.getText();

		}
		
			if (firstFlightStatus.contentEquals("En Route")) 
			{
				List<WebElement> arrivaleAirport = driver.findElements(By
					   .xpath("//div[@id='Body']/table[3]/tbody/tr[1]/td[4]"));
				for (WebElement resultItem1 : arrivaleAirport) {
					firstArrivaleAirport = resultItem1.getText();

				}
				
				List<WebElement> arrivaleAirport2 = driver.findElements(By	
						.xpath("//div[@id='Body']/table[3]/tbody/tr[2]/td[4]"));
				for (WebElement resultItem3 : arrivaleAirport2) {
					secondArrivaleAirport = resultItem3.getText();
			
				List<WebElement> date2 = driver.findElements(By
						.xpath("//div[@id='Body']/table[3]/tbody/tr[2]/td[1]"));
				for (WebElement resultItem4 : date2) {
					secondDate = resultItem4.getText();
				
				List<WebElement> flightStatus2 = driver.findElements(By
						.xpath("//div[@id='Body']/table[3]/tbody/tr[2]/td[7]"));
				for (WebElement resultItem5 : flightStatus2) {
					secondFlightStatus = resultItem5.getText();

				}
					}
				}
				driver.close();
				
			} 
			else if (firstFlightStatus.contentEquals("Scheduled")) 
			{
				List<WebElement> arrivaleAirport = driver.findElements(By
						.xpath("//div[@id='Body']/table[3]/tbody/tr[1]/td[4]"));
				for (WebElement resultItem1 : arrivaleAirport) {
					firstArrivaleAirport = resultItem1.getText();
				}
				
				List<WebElement> arrivaleAirport2 = driver.findElements(By
						.xpath("//div[@id='Body']/table[3]/tbody/tr[2]/td[4]"));
				for (WebElement resultItem3 : arrivaleAirport2) {
					secondArrivaleAirport = resultItem3.getText();
			
				List<WebElement> date2 = driver.findElements(By
						.xpath("//div[@id='Body']/table[3]/tbody/tr[2]/td[1]"));
				for (WebElement resultItem4 : date2) {
					secondDate = resultItem4.getText();
				
				List<WebElement> flightStatus2 = driver.findElements(By
						.xpath("//div[@id='Body']/table[3]/tbody/tr[2]/td[7]"));
				for (WebElement resultItem5 : flightStatus2) {
					secondFlightStatus = resultItem5.getText();
				}
					}
				}
				driver.close();
				
				
			} 
			else 
			{
				List<WebElement> resultList6 = driver
						.findElements(By
								.xpath("//div[@id='Body']/table[3]/tbody/tr[1]/td[4]"));
				for (WebElement resultItem6 : resultList6) {
					String tabname6 = resultItem6.getText();
				
				System.out.println("The "+ title+" is landed to "+tabname6 + " on "+ firstDate);
				}
				driver.close();
			}

		
		}
		driver.quit();
		System.out.println(firstDate);
		System.out.println(firstArrivaleAirport);
		System.out.println(firstFlightStatus);
		System.out.println(secondDate);
		System.out.println(secondArrivaleAirport);
		System.out.println(secondFlightStatus);
	}
}
