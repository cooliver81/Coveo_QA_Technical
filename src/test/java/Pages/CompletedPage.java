package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletedPage extends Page {

	public CompletedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void navigateToAllPage() {
		allButton = driver.findElement(By.xpath("//a[@href='#/']"));
		allButton.click();
	}
	
	public void navigateToActivePage() {
		activeButton = driver.findElement(By.xpath("//a[@href='#/active']"));
		activeButton.click();
	}
}
