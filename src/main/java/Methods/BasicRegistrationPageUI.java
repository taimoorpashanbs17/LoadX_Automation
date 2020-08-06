package Methods;
import Page.RegistrationPage;
import misc_operations.get_Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.logging.Logger;

public class BasicRegistrationPageUI {
    private static final Logger log = Logger.getLogger(Thread.currentThread().
            getStackTrace()[0].getClassName());
    RegistrationPage registerPage;
    WebDriver driver;
    String path = get_Path.GetFile("chromedriver_windows.exe");
    String baseURL = "https://www.loadx.co.uk/transporter-signup";

    @BeforeTest
    public void BeforeTest(){
        System.setProperty("webdriver.chrome.driver",
                path);
        driver= new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void VerifyTitle(){
        registerPage = new RegistrationPage(driver);
        registerPage.verifyTitle();
        log.info("Valid Title is displaying.");
    }

    @Test(priority = 2)
    public void LogoDisplayingAndClickable(){
        registerPage = new RegistrationPage(driver);
        registerPage.logoDisplaying();
        log.info("LoadX Image Logo is Displaying.");
        registerPage.logoClickable();
        log.info("LogoX Image Logo is Clickable.");
    }

    @Test (priority = 3)
    public void DateTimeNumberDisplayingAndClickable(){
        registerPage = new RegistrationPage(driver);
        registerPage.DateTimeNumberDisplaying();
        log.info("DateTime and Number Image Logo is Displaying.");
        registerPage.DateTimeNumberClickable();
        log.info("DateTime and Number Image Logo is Clickable.");
    }

    @Test (priority = 4)
    public void headerDisplayingAndVerifyingText(){
        registerPage = new RegistrationPage(driver);
        registerPage.largeHeaderDisplaying();
        registerPage.smallHeaderDisplaying();
        registerPage.verifyLargeHeaderText("Transporter Sign up");
        log.info("'Transporter Sign up' Text is Displaying.");
        registerPage.verifySmallHeaderText("Become a Transport Partner");
        log.info("'Become a Transport Partner' Text is Displaying.");
    }

    @AfterTest
    public void AfterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
