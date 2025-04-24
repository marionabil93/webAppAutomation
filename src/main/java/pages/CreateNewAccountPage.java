package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ConfigReader;
import java.util.UUID;
public class CreateNewAccountPage extends BasePage {
    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[contains(text(),'Create an Account')]")
    WebElement createAccountButton;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "email_address")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "password-confirmation")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@title='Create an Account']")
    WebElement createAccountBtn;


    @FindBy(xpath = "//div[@data-ui-id='message-success']")
    WebElement loginSuccessMsg;

    public void enterFirstName(String user) {
        enterText(firstName,user);
    }

    public void enterLastName(String user) {
        enterText(lastName,user);
    }

    public void enterEmail(String user) {
        enterText(email,user);
    }


    public void enterPassword(String user) {
        enterText(password,user);
    }

    public void enterConfirmPassword(String user) {
        enterText(confirmPassword,user);
    }



    public void verifyLoginSuccess() {
        String actualText = loginSuccessMsg.getText();
        Assert.assertTrue(actualText.contains(ConfigReader.getProperty("loginSuccess")) , "Login Success !");
    }

    public static String generateRandomMail() {
        String randomEmail = UUID.randomUUID().toString().substring(0, 9);
        return ConfigReader.getProperty("firstName") +ConfigReader.getProperty("lastName")
                + randomEmail + "@test.com";
    }


    public void registerUser() {
        clickElement(createAccountButton);
        enterFirstName(ConfigReader.getProperty("firstName"));
        enterLastName(ConfigReader.getProperty("lastName"));
        enterEmail(generateRandomMail());
        enterPassword(ConfigReader.getProperty("password"));
        enterConfirmPassword(ConfigReader.getProperty("confirmPassword"));
        clickElement(createAccountBtn);
    }


}
