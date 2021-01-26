# Coveo QA - IS Technical Test 

## Configuration
* I cloned the carina demo project and removed unecessary demo files and renamed the project
* Followed the Carina documentation: 
** Built the project with Maven
** Configured the Eclipse project with Java and Selenium libaries
** Downloaded and start the Selenium Standalone Server with Chromedriver

## Tests and Classes

I followed the POM model to test the webapp. The app is split into three pages: All, Active and Completed. Each of these pages function the same way, so I created a base class: Page to extend to classes corresponding to the three pages. The only functions implemented in the All, Active and Completed Page classes are for page navigation.

The tests were implemented sequentially. I tried to cover as many functionalities as possible and combine test cases while keeping the tests simple and clear. 

## Potential Improvements
* The test cases can be improved
** Many of the tests can be reimplemented for each page, verifying that they all work in the proper way. 
** The button to toggle all of the todos was not tested (details below in the "Problems" section)
* Classing the tests into groups to better organize the tests
* Adding priorities to the tests to increase usability of the tests
* As I wrote the tests, I realized that in a much larger test case, the readability could be improved. I did however try to keep it legible with clear variable and function names with thorough documentation. 

## Problems
* I had trouble at first with the configuration. At first I wasn't using the API source code properly with the Maven command to build the project. This led me to try to use the functionalities without the API, such as intializing and using RemoteWebDrivers myself. 
* I was also using the wrong java command to start the Selenium Standalone Server so I had problems connecting to it from the project at first. 
* There is still an issue I had testing the button to toggle all of the todos. The HTML element is an input and I'm not sure how to trigger it. I kept getting the error that it wasn't interactable.
