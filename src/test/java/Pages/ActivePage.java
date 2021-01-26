package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivePage extends Page {

	public ActivePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Function to navigate to All Page from Active Page
	public void navigateToAllPage() {
		allButton = driver.findElement(By.xpath("//a[@href='#/']"));
		allButton.click();
	}
	
	// Function to navigate to Completed Page from Active Page	
	public void navigateToCompletedPage() {
		completedButton = driver.findElement(By.xpath("//a[@href='#/completed']"));
		completedButton.click();
	}
}
