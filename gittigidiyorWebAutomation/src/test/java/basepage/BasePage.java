package basepage;

import homepage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {

    public WebDriverWait wait;
    public WebDriver driver;


    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public BasePage() {


    }

}
