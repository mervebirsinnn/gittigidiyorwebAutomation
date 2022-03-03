# Automated test example in Java with Cucumber and Selenium WebDriver #

This project is an example of UI automated functional test for Gittigidiyor web site using Selenium and Cucumber.

Test scenarios are described in the feature files located here ./src/test/resources/com/sample.

## Installation ##

You need to have [Java 15 JDK](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) installed along with [maven](https://maven.apache.org/download.cgi).

To run the tests locally with Chrome, install ChromeDriver from [here](http://chromedriver.chromium.org), add its location to your system PATH and add webdriver.chrome.driver=path/to/the/driver to your local variables.

To run the tests locally with Firefox, install GeckoDriver from [here](https://github.com/mozilla/geckodriver/releases) and add its location to your system PATH.

To install all dependencies, run 

```console
$ mvn clean install
```

## Running tests ##

You can run any scenario you want
```console

mainTest.feature 
```

By default, tests will run on Chrome. To change that you need to change driver path and browser must be firefox.
