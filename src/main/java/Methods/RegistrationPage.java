package Methods;
import misc_operations.get_Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
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
    String nameToBeEntered = "Taimoor Pasha";
    String emailToBeEntered = "tam45@gmail.com";
    String registeredEmailToBeEntered = "tam44@gmail.com";
    String phoneNumberToBeEntered = "03214874154";
    String addressToBeEntered = "Newquay, UK";
    String registeredNumberToBeEntered = "BM-090";
    String makeNameToBeEntered = "Lexus";
    String loginURL = "https://www.loadx.co.uk/login";
    String modelNameToBeEntered = "GS";
    String imageName = "driver-license.jpg";
    String imageUploadMessage = "View Image";


    @BeforeMethod
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver",
                path);
        driver= new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }
    @Test (priority = 2)
    public void checkDataEnteredCorrectlyInTextFields(){
        registerPage = new Page.RegistrationPage(driver);
        registerPage.enterFullName(nameToBeEntered);
        registerPage.verifyTextEnteredCorrectly(registerPage.name_field, nameToBeEntered);
        log.info("Name entered is correct");
        registerPage.enterEmailAddress(emailToBeEntered);
        registerPage.verifyTextEnteredCorrectly(registerPage.email_field, emailToBeEntered);
        log.info("Email entered is correct");
        registerPage.enterPhoneNumber(phoneNumberToBeEntered);
        registerPage.verifyTextEnteredCorrectly(registerPage.phone_field, phoneNumberToBeEntered);
        log.info("Phone Number entered is correct");
        registerPage.enterAddress(addressToBeEntered);
        registerPage.verifyTextEnteredCorrectly(registerPage.address_field, addressToBeEntered);
        log.info("Address Entered entered is correct");
        registerPage.enterRegisterNumber(registeredNumberToBeEntered);
        registerPage.verifyTextEnteredCorrectly(registerPage.registrationNumber_field,
                registeredNumberToBeEntered);
        log.info("Registration Number entered is correct");
    }

    @Test(priority = 1)
    public void checkAlreadyAccountCreatedWorking(){
        registerPage = new Page.RegistrationPage(driver);
        registerPage.verifyAlreadyLoginLinkDisplaying();
        log.info("'Already Have an Account?' link is Displaying.");
        registerPage.verifyAlreadyLoginButtonClickable();
        log.info("'Already Have an Account?' link is Clickable.");
        registerPage.verifyURLChanges(loginURL);
        log.info("URL is valid and Navigation Happening Right.");
    }

    @Test(priority = 3)
    public void checkDrivingLicenseImageUpload() throws AWTException, InterruptedException {
        registerPage = new Page.RegistrationPage(driver);
        registerPage.scrollDownTo(driver.findElement(registerPage.viewDriverLicenseImageSuccessfully));
        registerPage.UploadImage(get_Path.GetFile(imageName));
        log.info("Driving License Image is Uploaded.");
        Thread.sleep(4000);
        registerPage.verifyImageUploadButtonDisplayed(registerPage.viewDriverLicenseImageSuccessfully);
        log.info("View Image Link is displaying.");
        registerPage.verifyTextEnteredDisplaying((registerPage.viewDriverLicenseImageSuccessfully),
                imageUploadMessage);
        log.info("'View Text' Text is displaying. ");
    }

    @Test(priority = 4)
    public void checkLicenseCopyImageUpload() throws AWTException, InterruptedException {
        registerPage = new Page.RegistrationPage(driver);
        registerPage.scrollDownTo(driver.findElement(registerPage.viewInsuranceCopyImageSuccessfully));
        registerPage.UploadInsuranceCopy(get_Path.GetFile(imageName));
        log.info("Insurance Copy Image is Uploaded.");
        Thread.sleep(4000);
        registerPage.verifyImageUploadButtonDisplayed(registerPage.viewInsuranceCopyImageSuccessfully);
        log.info("View Image Link is displaying.");
        registerPage.verifyTextEnteredDisplaying((registerPage.viewInsuranceCopyImageSuccessfully),
                imageUploadMessage);
        log.info("'View Text' Text is displaying. ");
    }

    @Test(priority = 5)
    public void checkBasicRegistration() throws AWTException, InterruptedException {
        registerPage = new Page.RegistrationPage(driver);
        registerPage.enterFullName(nameToBeEntered);
        log.info("Full Name Entered as "+nameToBeEntered);
        registerPage.enterEmailAddress(emailToBeEntered);
        log.info("Email address Entered as "+emailToBeEntered);
        registerPage.enterPhoneNumber(phoneNumberToBeEntered);
        log.info("Phone Number Entered as "+phoneNumberToBeEntered);
        registerPage.enterAddress(addressToBeEntered);
        log.info("Address Entered as "+addressToBeEntered);
        registerPage.scrollDownTo(driver.findElement(registerPage.address_field));
        registerPage.selectVehicle(4);
        log.info("Vehicle Selected.");
        registerPage.enterRegisterNumber(registeredNumberToBeEntered);
        log.info("Registration Number entered.");
        registerPage.selectCarMake(makeNameToBeEntered);
        log.info("Car Make Selected");
        registerPage.selectCarModel(modelNameToBeEntered);
        log.info("Car Make Selected.");
        registerPage.UploadImage(get_Path.GetFile(imageName));
        log.info("Driver License Image Uploaded.");
        registerPage.UploadInsuranceCopy(get_Path.GetFile(imageName));
        log.info("Insurance Copy Uploaded.");
        Thread.sleep(3000);
        registerPage.submitRegisteration();
        log.info("Registration Completed.");
        registerPage.verifyURLChanges(UpdatedURL);
        log.info("URL is updated one.");
        registerPage.verifySuccessLogoDisplaying();
        log.info("Success Logo is Displaying.");
        registerPage.verifySuccessMessageDisplaying();
        log.info("Success Message is Displaying.");
    }

    @AfterMethod
    public void AfterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}