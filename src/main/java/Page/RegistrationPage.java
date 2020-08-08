package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;


public class RegistrationPage {
    WebDriver driver;
    By logo_loadX = By.xpath("//*[@id=\"logo\"]/a[1]");
    By dateTime_number_Logo = By.xpath("//*[@id=\"header\"]/div/div[2]/div");
    By header1 = By.tagName("h2");
    By header2 = By.tagName("h3");
    public By name_field = By.id("name");
    public By email_field = By.id("email");
    public By phone_field = By.id("phone");
    public By address_field = By.id("address");
    public By vehicle_dropdown = By.xpath("//*[@id=\"contactform\"]//div[4]//div");
    public By registrationNumber_field = By.id("registration-number");
    By carMake_dropdown = By.id("car_make_brand_id");
    By carModel_dropdown = By.id("car_model_id");
    public By drivingLicense_button = By.xpath("//*[@id=\"contactform\"]//div[9]/div/label");
    By insuranceCopy_button = By.xpath("//*[@id=\"contactform\"]//div[10]/div/label");
    public By registerNow_button = By.id("submit");
    By success_logo = By.xpath("//*[@id=\"wrapper\"]/div[2]//div/center[1]/img");
    By successMessage = By.tagName("h1");
    By alreadyLogin_link = By.linkText("Already Have An Account?");
    public By viewDriverLicenseImageSuccessfully = By.xpath("//*[@id=\"contactform\"]//div[9]/div/a");
    public By viewInsuranceCopyImageSuccessfully = By.xpath("//*[@id=\"contactform\"]//div[10]/div/a");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait explicitWait() {
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, 30);
        return wait;
    }

    public void waitTillElementClickable(By my_driver, WebDriver element) {
        try {
            WebDriverWait wait = new WebDriverWait((WebDriver) my_driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable((By) element));
        } catch (Exception ignored) {
        }
    }

    public void verifyTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Join LoadX For Free");
    }

    public void logoClickable() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitTillElementClickable(logo_loadX, driver);
    }

    public void logoDisplaying() {
        boolean display_logo = driver.findElement(logo_loadX).isDisplayed();
        Assert.assertTrue(display_logo);
    }

    public void DateTimeNumberClickable() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitTillElementClickable(dateTime_number_Logo, driver);
    }

    public void DateTimeNumberDisplaying() {
        boolean display_logo = driver.findElement(dateTime_number_Logo).isDisplayed();
        Assert.assertTrue(display_logo);
    }

    public void largeHeaderDisplaying() {
        boolean header = driver.findElement(header1).isDisplayed();
        Assert.assertTrue(header);
    }

    public void smallHeaderDisplaying() {
        boolean header = driver.findElement(header2).isDisplayed();
        Assert.assertTrue(header);
    }

    public void verifyLargeHeaderText(String text) {
        String header = driver.findElement(header1).getText();
        Assert.assertEquals(header, text);
    }

    public void verifySmallHeaderText(String text) {
        String header = driver.findElement(header2).getText();
        Assert.assertEquals(header, text);
    }


    public void enterFullName(String name) {
        driver.findElement(name_field).sendKeys(name);
    }

    public void enterEmailAddress(String email) {
        driver.findElement(email_field).sendKeys(email);
    }

    public void enterPhoneNumber(String number) {
        driver.findElement(phone_field).sendKeys(number);
    }

    public void enterAddress(String address) {
        driver.findElement(address_field).sendKeys(address);
    }

    public void selectVehicle(int vehicle_index) {
        driver.findElement(vehicle_dropdown).click();
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.xpath("//*[@id=\"contactform\"]//div[4]//div/ul/li[" +
                vehicle_index + "]/a"))).perform();
    }

    public void enterRegisterNumber(String registrationNumber) {
        driver.findElement(registrationNumber_field).sendKeys(registrationNumber);
    }

    public void selectCarMake(String makeName) {
        Select selectMake = new Select(driver.findElement(carMake_dropdown));
        selectMake.selectByVisibleText(makeName);
    }

    public void selectCarModel(String makeModel) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(carModel_dropdown),
                "Select Model"));
        Select selectModel = new Select(driver.findElement(carModel_dropdown));
        selectModel.selectByVisibleText(makeModel);
    }

    public void UploadImage(String filePath) throws AWTException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        WebElement drivingLicense = driver.findElement(drivingLicense_button);
        registrationPage.waitTillElementClickable(drivingLicense_button, driver);
        drivingLicense.click();
        driver.switchTo().activeElement().sendKeys(filePath);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
    }

    public void UploadInsuranceCopy(String filePath) throws AWTException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        WebElement insuraceLicense = driver.findElement(insuranceCopy_button);
        registrationPage.waitTillElementClickable(insuranceCopy_button, driver);
        insuraceLicense.click();
        driver.switchTo().activeElement().sendKeys(filePath);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
    }

    public void submitRegisteration() {
        driver.findElement(registerNow_button).click();
    }

    public void verifyURLChanges(String newURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, newURL);
    }

    public void verifySuccessLogoDisplaying() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(success_logo));
        boolean logo = driver.findElement(success_logo).isDisplayed();
        Assert.assertTrue(logo);

    }

    public void scrollDownTo(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void verifySuccessMessageDisplaying() {
        boolean message = driver.findElement(successMessage).isDisplayed();
        Assert.assertTrue(message);
    }

    public void verifyTextEnteredCorrectly(By element, String text) {
        String name_value = driver.findElement(element).getAttribute("value");
        Assert.assertEquals(name_value, text);
    }

    public void verifyTextEnteredDisplaying(By element, String text) {
        String name_value = driver.findElement(element).getText();
        Assert.assertEquals(name_value, text);
    }

    public void verifyAlreadyLoginLinkDisplaying() {
        boolean alreadyLoginButton = driver.findElement(alreadyLogin_link).isDisplayed();
        Assert.assertTrue(alreadyLoginButton);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.scrollDownTo(driver.findElement(alreadyLogin_link));
    }

    public void verifyAlreadyLoginButtonClickable() {
        WebElement alreadyLoginButton = driver.findElement(alreadyLogin_link);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitTillElementClickable(dateTime_number_Logo, driver);
        alreadyLoginButton.click();
    }

    public void verifyImageUploadButtonDisplayed(By element){
        WebElement imageUplaodMessage = driver.findElement(element);
        boolean imageUpload = imageUplaodMessage.isDisplayed();
        Assert.assertTrue(imageUpload);
    }
}
