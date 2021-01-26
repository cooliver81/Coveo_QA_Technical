package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletedPage extends Page {

	public CompletedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Function to navigate to the All Page from Completed Page
	public void navigateToAllPage() {
		allButton = driver.findElement(By.xpath("//a[@href='#/']"));
		allButton.click();
	}
	
	// Function to navigate to the Active Page from Completed Page
	public void navigateToActivePage() {
		activeButton = driver.findElement(By.xpath("//a[@href='#/active']"));
		activeButton.click();
	}
}
