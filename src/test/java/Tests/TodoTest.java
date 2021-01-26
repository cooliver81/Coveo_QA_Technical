package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import Pages.ActivePage;
import Pages.AllPage;
import Pages.CompletedPage;

public class TodoTest extends AbstractTest {
    
	AllPage allPage;
	ActivePage activePage;
	CompletedPage completedPage;
	WebDriver driver = getDriver();
	
	@BeforeSuite
    public void startPages() {
		driver.navigate().to("https://todomvc.com/examples/react/#/");
		allPage = new AllPage(driver);
		activePage = new ActivePage(driver);
		completedPage = new CompletedPage(driver);
    }
	
	/* Test adding two todos one from all adn one from completed
	 * 
	 * 
	 * */
    @Test
	public void testAddingTwoTodos() {
		allPage.addTodo("todo1");
		allPage.navigateToCompletedPage();
		completedPage.addTodo("todo2");

    	int numberOfCompleted = completedPage.getTodos().size();
    	Assert.assertEquals(numberOfCompleted, 0);
		
    	completedPage.navigateToAllPage();
    	
		String activeCount = driver.findElement(By.tagName("strong")).getText();
		Assert.assertEquals(activeCount, "2");
	}
    
    // Test completing a todo and check Active and Completed
    @Test
    public void testCompleteTodo() {
    	allPage.toggleTodo(1);
    	int numberOfAll = allPage.getTodos().size();
    	List<WebElement> namesOfAll = allPage.getTodos();
    	Assert.assertEquals(numberOfAll, 2);
    	Assert.assertEquals(namesOfAll.get(0).getText(), "todo1");
    	Assert.assertEquals(namesOfAll.get(1).getText(), "todo2");
    	
    	allPage.navigateToActivePage();
    	int numberOfActive = activePage.getTodos().size();
    	String nameOfActive = activePage.getTodo(0).getText();
    	Assert.assertEquals(numberOfActive, 1);
    	Assert.assertEquals(nameOfActive, "todo1");
    	
    	activePage.navigateToCompletedPage();
    	int numberOfCompleted = completedPage.getTodos().size();
    	String nameOfCompleted = completedPage.getTodo(0).getText();
    	Assert.assertEquals(numberOfCompleted, 1);
    	Assert.assertEquals(nameOfCompleted, "todo2");
    	
    	completedPage.navigateToAllPage();
    }
    
    // Test completing a todo in Active
    @Test
    public void testCompleteTodoFromActivePage() {
    	allPage.navigateToActivePage();
    	activePage.addTodo("todo5");
    	activePage.toggleTodo(1);
    	int numberOfActive = activePage.getTodos().size(); 
    	String nameOfActive = activePage.getTodo(0).getText();
    	Assert.assertEquals(numberOfActive, 1);
    	Assert.assertEquals(nameOfActive, "todo1");
    	
    	activePage.navigateToAllPage();
    }
    
    // Test delete all clears
    @Test
    public void testDeleteAllClearedTodos() {
    	allPage.toggleTodo(1);
    	allPage.deleteAllCompletedTodos();
    	int numberOfAll = allPage.getTodos().size();
    	List<WebElement> namesOfAll = allPage.getTodos();
    	Assert.assertEquals(numberOfAll, 2);
    	Assert.assertEquals(namesOfAll.get(0).getText(), "todo1");
    	Assert.assertEquals(namesOfAll.get(1).getText(), "todo2");

    	
    	allPage.navigateToActivePage();
    	int numberOfActive = activePage.getTodos().size();
    	List<WebElement> namesOfActive = activePage.getTodos();
    	Assert.assertEquals(numberOfActive, 2);
    	Assert.assertEquals(namesOfActive.get(0).getText(), "todo1");
    	Assert.assertEquals(namesOfActive.get(1).getText(), "todo2");
    	
    	activePage.navigateToCompletedPage();
    	int numberOfCompleted = completedPage.getTodos().size();
    	Assert.assertEquals(numberOfCompleted, 0);
    	
    	completedPage.navigateToAllPage();
    }
	
    // Test deleting an active todo and check Active and Completed = *
    @Test
    public void testDeleteTodo() {
    	allPage.deleteTodo(0);
    	int numberOfAll = allPage.getTodos().size();
    	List<WebElement> namesOfAll = allPage.getTodos();
    	Assert.assertEquals(numberOfAll, 1);
    	Assert.assertEquals(namesOfAll.get(0).getText(), "todo2");
    	
    	allPage.navigateToActivePage();
    	int numberOfActive = activePage.getTodos().size();
    	String nameOfActive = activePage.getTodo(0).getText();
    	Assert.assertEquals(numberOfActive, 1);
    	Assert.assertEquals(nameOfActive, "todo2");
    	
    	activePage.navigateToCompletedPage();
    	int numberOfCompleted = completedPage.getTodos().size();
    	Assert.assertEquals(numberOfCompleted, 0);
    	
    	completedPage.navigateToAllPage();
    }
    
    // Test double click to modify and modifying *
    @Test
    public void testModifyTodoText() {
    	allPage.modifyTodoText(0, "edit");
    	int numberOfAll = allPage.getTodos().size();
    	List<WebElement> namesOfAll = allPage.getTodos();
    	Assert.assertEquals(numberOfAll, 1);
    	Assert.assertEquals(namesOfAll.get(0).getText(), "todo2edit");
    	
    	allPage.navigateToActivePage();
    	int numberOfActive = activePage.getTodos().size();
    	String nameOfActive = activePage.getTodo(0).getText();
    	Assert.assertEquals(numberOfActive, 1);
    	Assert.assertEquals(nameOfActive, "todo2edit");
    	
    	activePage.navigateToCompletedPage();
    	int numberOfCompleted = completedPage.getTodos().size();
    	Assert.assertEquals(numberOfCompleted, 0);
    	
    	completedPage.navigateToAllPage();
    }
    
	// Test uncompleting a completed todo
    @Test
    public void testUncompleteTodo() {
    	allPage.addTodo("todo3");
    	allPage.toggleTodo(0);
    	allPage.toggleTodo(1);
    	allPage.toggleTodo(1);
    	
    	int numberOfAll = allPage.getTodos().size();
    	List<WebElement> namesOfAll = allPage.getTodos();
    	Assert.assertEquals(numberOfAll, 2);
    	Assert.assertEquals(namesOfAll.get(0).getText(), "todo2edit");
    	Assert.assertEquals(namesOfAll.get(1).getText(), "todo3");
    	
    	allPage.navigateToActivePage();
    	int numberOfActive = activePage.getTodos().size();
    	String nameOfActive = activePage.getTodo(0).getText();
    	Assert.assertEquals(numberOfActive, 1);
    	Assert.assertEquals(nameOfActive, "todo3");
    	
    	activePage.navigateToCompletedPage();
    	int numberOfCompleted = completedPage.getTodos().size();
    	String nameOfCompleted = completedPage.getTodo(0).getText();
    	Assert.assertEquals(numberOfCompleted, 1);
    	Assert.assertEquals(nameOfCompleted, "todo2edit");
    	
    	completedPage.navigateToAllPage();
    	
    	for (WebElement i : allPage.getTodos()) {
        	System.out.println(i.getText());
    	}
    }
}







