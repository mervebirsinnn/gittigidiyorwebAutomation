
package homepage;
import basepage.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class HomePageSteps extends BasePage {


       private HomePage homePage;
    String projectPath = System.getProperty("user.dir");
    String result = projectPath + "\\src\\main\\resources\\results.txt";

    public static String GirisXpath = "//*[contains(text(),'Giriş Yap')]";
    public static String GirisButonXpath = "//span[contains(text(),'Giriş Yap')]";
    public static String CikisXpath = "//a[@title='Çıkış']";
    public static String HesabimXpath = "//div[@title='Hesabım']";
    public  static  String hataXpath = "//*[contains(text(),'Geçersiz Kullanıcı Adı ve/veya Şifre.')]";
    public static String PopupXpath ="//div[@class='dn-slide-buttons horizontal']//button[text()='Daha Sonra']";
    public static String mailId = "L-UserNameField";
    public static String passwordId = "L-PasswordField";
    public static String loginButtonId = "gg-login-enter";
    public static String searchBoxName =  "k";
    public static String key ="Masa";
    public static String secondKey ="a";
    public static String searchButtonXpath = "//button[@class='qjixn8-0 sc-1bydi5r-0 gaMakD']/span";
    public static String secondPageXpath = "//a[text()='2']";
    public static String emptyXpath = "//*[contains(text(),'Ne Aramıştınız?')]";
    public static String productPageXpath="//*[contains(text(),'Ürünü hangi ')]";

    public HomePageSteps() {
        this.homePage = new HomePage();

    }

        @Given("Kullanıcı Ana sayfaya gider")
        public void UygulamaGirisSayfasıAcılır () {
            this.homePage.openApplication();
        }


    @When("Kullanıcı sayfanın yüklendiğini görür")
    public void kullanıcıSayfanınYüklendiğiniGörür() {
        this.homePage.VerifyFullyLoaded2(homePage.driver);
    }

    @When("Kullanıcı giriş yap butonuna tıklar")
    public void Kullanicigirisyapbutonunatiklar() {
             homePage.hoverClick(By.xpath(GirisXpath));
             homePage.wait(By.xpath(GirisButonXpath));
            this.homePage.click(By.xpath(GirisButonXpath));
    }



    @When("Kullanıcı mail ve şifre girer")
    public void kullanıcıMailVeŞifreGirer() throws InterruptedException {
                    homePage.wait(By.id(mailId));
                    homePage.writeText(By.id(mailId),"mervebirsin99@gmail.com");
                    homePage.wait(By.id(passwordId));
                    homePage.writeText(By.id(passwordId),"sakarya56");
                    homePage.click(By.id(loginButtonId));

        }
    @When("Kullanıcı mail ve yanlıs sifre girer")
    public void KullanıcıMailVeYanlısSifreGirer() throws InterruptedException {
        Thread.sleep(5000);
        homePage.writeText(By.id(mailId),"mervebirsin99@gmail.com");
        Thread.sleep(5000);
        homePage.writeText(By.id(passwordId),"1234Qwerty");
        homePage.click(By.id(loginButtonId));


    }

    @When("Kullanıcı login butonuna tıklar")
    public void kullanıcıLoginButonunaTıklar() throws InterruptedException {
        Thread.sleep(7000);
        homePage.click(By.id(loginButtonId));
    }

    @Then("Kullanıcı Log out olur")
    public void kullanıcıLogOutOlur() throws InterruptedException {
            homePage.wait(By.xpath(HesabimXpath));
            homePage.hoverClick(By.xpath(HesabimXpath));
            homePage.wait(By.xpath(CikisXpath));
            homePage.click(By.xpath(CikisXpath));
            homePage.driver.quit();
    }

    @Then("Kullanıcı hatalı giriş uyarısını görür")
    public void kullanıcıUyariGorur() throws InterruptedException {
        Thread.sleep(10000);
       Assert.assertTrue(homePage.getText1(By.xpath(hataXpath)).equals("Geçersiz Kullanıcı Adı ve/veya Şifre."));
        homePage.driver.quit();
    }

    @And("Arama çubuğuna ürün girer")
    public void aramaCubugunaUrünGirer() {
            homePage.writeText(By.name(searchBoxName),key);
    }
    @And("Arama çubuğuna olmayan ürün girer")
    public void aramaCubugunaOlmayanUrünGirer() {
        homePage.writeText(By.name(searchBoxName),secondKey);
    }

    @And("Arama butonuna tıklar")
    public void aramaButonunaTıklar() {
            homePage.click(By.xpath(searchButtonXpath));
        Assert.assertTrue(homePage.getText1(By.xpath(productPageXpath)).equals("Ürünü hangi kategori için arıyorsunuz?"));




    }

    @And("Olmayan ürün için Arama butonuna tıklar")
    public void OlmayanUrunIcinaramaButonunaTıklar() {
        homePage.click(By.xpath(searchButtonXpath));
       Assert.assertTrue(homePage.getText1(By.xpath(emptyXpath)).equals("Ne Aramıştınız? Türkçe karakter kullanabilirsiniz"));
       homePage.driver.quit();

    }

    @Then("Arama sonuçları results.txtye kaydedilir")
    public void aramaSonuçlarıResultsTxtyeKaydedilir() {
        homePage.saveSearchProduct(result, key);
        homePage.driver.quit();

    }

    @When("Config.txtden mail ve şifre girilir")
    public void dosyadanMailVeSifreGirer() throws InterruptedException, IOException {
        Thread.sleep(5000);
        homePage.writeWithParameterUsername(By.id(mailId));
        Thread.sleep(5000);
        homePage.writeWithParameterPassword(By.id(passwordId));
        homePage.click(By.id(loginButtonId));

    }
}
