package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllPage extends Page {

	public AllPage(WebDriver driver) {
		super(driver);
	}

	// Function to navigate to the Active Page from All Page
	public void navigateToActivePage() {
		activeButton = driver.findElement(By.xpath("//a[@href='#/active']"));
		activeButton.click();
	}
	
	// Function to navigate to the Completed Page from All Page
	public void navigateToCompletedPage() {
		completedButton = driver.findElement(By.xpath("//a[@href='#/completed']"));
		completedButton.click();
	}
}
