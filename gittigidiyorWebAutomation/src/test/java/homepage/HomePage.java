package homepage;

import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


import java.io.*;
import java.util.ArrayList;


public class HomePage  extends BasePage {

    String projectPath = System.getProperty("user.dir");
    String file = projectPath + "\\src\\main\\resources\\config.txt";
    public static final String loginPageUrl = "https://www.n11.com/";
    public Actions action;
    ArrayList<String> products = new ArrayList<String>();
    String productName;
    String mail;
    String password;
    String searchTerm;

    private HomePageSteps homePageSteps;
    HomePage() {
        super();
        PageFactory.initElements(driver, this); }

    public void wait(By elementLocation){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void click(By elementLocation){
        driver.findElement(elementLocation).click();
    }

    public void clear(By elementLocation){
        driver.findElement(elementLocation).clear();
    }

    public void hoverClick(By elementLocation){
        this.action = new Actions(driver);
        action.moveToElement(driver.findElement(elementLocation)).click().build().perform();
        driver.findElement(elementLocation).click();
    }

    public String getText1(By elementLocation){
        String text= this.driver.findElement(elementLocation).getText();
        return text;
    }

    public void firstResult(By elementLocation){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public void VerifyFullyLoaded2(WebDriver driver){ //to verify page ready or not

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String ready = (String)js.executeScript("return document.readyState");
        System.out.println("Ready or not : "+ready);
    }
    public void writeText(By elementLocation, String text){ //this method sending keys to specified element location

        driver.findElement(elementLocation).sendKeys(text);

    }
    public void sendKeyEnter(By elementLocation){
        driver.findElement(elementLocation).sendKeys(Keys.ENTER);
    }

  public void openApplication()
  {
      String projectPath = System.getProperty("user.dir");
      String browser = "chrome";
      switch (browser) {
          case "chrome":
              System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\chromedriver.exe");
              this.driver = new ChromeDriver();
              String url = "https://www.gittigidiyor.com/";
              this.driver.get(url);
              this.driver.manage().window().maximize();
              break;
          case "firefox":
              System.setProperty("webdriver.gecko.driver", projectPath + "\\src\\main\\resources\\geckodriver.exe");
              driver = new FirefoxDriver();
              driver.manage().window().maximize();
              break;
          default:
              throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
      }
  }




    public String getattribute(By elementLocation){

       return driver.findElement(elementLocation).getAttribute("title");
    }
   

    public void writeWithParameterUsername(By elementLocation) throws IOException { //this method sending keys to specified element location from a file


        File file = new File(projectPath + "\\src\\main\\resources\\config.txt");


        BufferedReader br = new BufferedReader(new FileReader(file));


        String st;
        while ((st = br.readLine()) != null)
         if(st.contains("Username:"))
         {
            String[] username = st.split(" ");
             mail = username[1];
             driver.findElement(elementLocation).sendKeys(mail);
         }

    }
    public void writeWithParameterPassword(By elementLocation) throws IOException { //this method sending keys to specified element location from a file


        File file = new File(projectPath + "\\src\\main\\resources\\config.txt");


        BufferedReader br = new BufferedReader(new FileReader(file));


        String st;
        while ((st = br.readLine()) != null)

             if(st.contains("Password:"))
            {
                String[] passwordToken = st.split(" ");
                password = passwordToken[1];
                driver.findElement(elementLocation).sendKeys(password);
            }
    }
    public void writeWithParameterSearcTerm(By elementLocation) throws IOException { //this method sending keys to specified element location from a file


        File file = new File(projectPath + "\\src\\main\\resources\\config.txt");


        BufferedReader br = new BufferedReader(new FileReader(file));


        String st;
        while ((st = br.readLine()) != null)

            if(st.contains("SearchTerm:"))
            {
                String[] searhTermToken = st.split(" ");
                searchTerm = searhTermToken[1];
                driver.findElement(elementLocation).sendKeys(searchTerm);
            }

    }
    public void saveSearchProduct(String filePath, String key) {


        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(filePath));
            myWriter.write("aranan key:"+key);
            for (int i =1 ; i<32 ; i++)
            {
                products.add(getText1(By.xpath("//li[@class='sc-1nx8ums-0 dyekHG']["+i+"]")));


            }
            String[] tokens = products.toString().split("\n");
            for (int i = 0; i<32; i++)
            {
                if(tokens[i].contains("Masa"))
                {
                      productName =tokens[i];
                      myWriter.newLine();
                      myWriter.write(productName);

                }
            }

            myWriter.close();


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
