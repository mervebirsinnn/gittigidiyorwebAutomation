# gittigidiyorwebAutomation

Automated test example in Java with Cucumber and Selenium WebDriver
This project is an example of UI automated functional test for Gittigidiyor web site using Selenium and Cucumber.

Test scenarios are described in the feature files located here ./src/test/resources/com/sample.

Installation
You need to have Java 15 JDK installed along with maven.

To run the tests locally with Chrome, install ChromeDriver from here, add its location to your system PATH and add webdriver.chrome.driver=path/to/the/driver to your local variables.

To run the tests locally with Firefox, install GeckoDriver from here and add its location to your system PATH.

To install all dependencies, run

$ mvn clean install
Running tests
You can run any scenario you want

mainTest.feature 
By default, tests will run on Chrome. To change that you need to change driver path and browser must be firefox.
