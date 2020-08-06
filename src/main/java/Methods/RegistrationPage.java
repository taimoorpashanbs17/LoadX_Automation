package Methods;
import misc_operations.get_Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.*;
import java.util.logging.Logger;

public class RegistrationPage {
    private static final Logger log = Logger.getLogger(Thread.currentThread().
            getStackTrace()[0].getClassName());
    Page.RegistrationPage registerPage;
    WebDriver driver;
    String path = get_Path.GetFile("chromedriver_windows.exe");
    String baseURL = "https://www.loadx.co.uk/transporter-signup";
    String UpdatedURL = "https://www.loadx.co.uk/success";

    @BeforeTest
    public void BeforeTest(){
        System.setProperty("webdriver.chrome.driver",
                path);
        driver= new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test
    public void basicRegistration() throws AWTException, InterruptedException {
        registerPage = new Page.RegistrationPage(driver);
        registerPage.enterFullName("Taimoor Pasha");
        log.info("Full Name Entered.");
        registerPage.enterEmailAddress("taimoor21@gmail.com");
        log.info("Email address Entered.");
        registerPage.enterPhoneNumber("03214929285");
        log.info("Phone Number Entered.");
        registerPage.enterAddress("Newquay, UK");
        log.info("Address Entered.");
        registerPage.selectVehicle(4);
        log.info("Vehicle Selected.");
        registerPage.enterRegisterNumber("BM-090");
        log.info("Registration Number entered.");
        registerPage.selectCarMake("Lexus");
        log.info("Car Make Selected");
        registerPage.selectCarModel("GS");
        log.info("Car Make Selected.");
        registerPage.UploadImage(get_Path.GetFile("driver-license.jpg"));
        log.info("Driver License Image Uploaded.");
        registerPage.UploadInsuranceCopy(get_Path.GetFile("driver-license.jpg"));
        log.info("Insurance Copy Uploaded.");
        Thread.sleep(5000);
        registerPage.submitRegisteration();
        log.info("Registration Completed.");
        registerPage.verifyURLChanges(UpdatedURL);
        log.info("URL is updated one.");
        registerPage.verifySuccessLogoDisplaying();
        log.info("Success Logo is Displaying.");
        registerPage.verifySuccessMessageDisplaying();
        log.info("Success Message is Displaying.");
    }

    @AfterTest
    public void AfterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
