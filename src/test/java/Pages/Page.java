package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class Page extends AbstractPage {
	
	public Page(WebDriver driver) {
		super(driver);
	}

	protected WebDriver driver = getDriver();
	private WebElement todoTextField;
	private List<WebElement> todoList;
	private List<WebElement> completeButtons;
	private List<WebElement> deleteButtons;
	private WebElement deleteAllClearedButton;
	protected WebElement allButton;
	protected WebElement activeButton;
	protected WebElement completedButton;
	
	// Function to write a todo in the textbox and add it to the list
	public void addTodo(String todoText) {
		todoTextField = driver.findElement(By.className("new-todo"));
		todoTextField.sendKeys(todoText + Keys.ENTER);
	}
	
	// Function that returns a list of all the todos currently displayed 
	public List<WebElement> getTodos() {
		todoList = driver.findElements(By.tagName("label"));
		// There is an object with tagName "label" with no text which needs to be removed
		// Cannot have a todo with empty text so this if will remove only that object (it will always be first)
		if (todoList.get(0).getText() == "") {
			todoList.remove(0);			
		}
		return todoList;
	}
	
	// Function that returns a specific todo from the list, specified by the current placement in the list
	public WebElement getTodo(int todoNumber) {
		getTodos();
		return todoList.get(todoNumber);
	}
	
	// Function that toggles the complete button for a todo, specified by the current placement in the list
	public void toggleTodo(int todoNumber) {
		completeButtons = driver.findElements(By.className("toggle"));
		completeButtons.get(todoNumber).click();
	}
	
	// Function that clicks the delete button for a todo, specified by the current placement in the list
	public void deleteTodo(int todoNumber) {
		deleteButtons = driver.findElements(By.className("destroy"));
		deleteButtons.get(todoNumber).click();
	}
	
	// Function that clicks the "Clear Completed" button 
	public void deleteAllCompletedTodos() {
		deleteAllClearedButton = driver.findElement(By.className("clear-completed"));
		deleteAllClearedButton.click();
	}
	
	// **THIS FUNCTION IS NOT TESTED AND DOES NOT WORK**
	// Function that clicks on the button to toggle all todos
	public void toggleAllTodos() {
		driver.findElement(By.id("toggle-all"));
	}
	
	// Function to modify the text of a todo specified by its current placement in the list
	public void modifyTodoText(int todoNumber, String todoText) {
		Actions actions = new Actions(driver);
		WebElement todo = getTodo(todoNumber);
		actions.doubleClick(todo).perform();;
		WebElement editText = driver.findElement(By.className("edit"));
		editText.sendKeys(todoText + Keys.ENTER);
	}
	
	// Function to check the current page URL
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
 }
