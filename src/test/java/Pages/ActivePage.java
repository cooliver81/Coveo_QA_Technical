package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivePage extends Page {

	public ActivePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void navigateToAllPage() {
		allButton = driver.findElement(By.xpath("//a[@href='#/']"));
		allButton.click();
	}
	
	public void navigateToCompletedPage() {
		completedButton = driver.findElement(By.xpath("//a[@href='#/completed']"));
		completedButton.click();
	}
}
