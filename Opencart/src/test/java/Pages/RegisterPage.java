package Pages;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

  @FindBy(id = "input-firstname")
  WebElement firstNameField;

  @FindBy(id = "input-lastname")
  WebElement lastNameField;

  @FindBy(id = "input-email")
  WebElement emailField;

  @FindBy(id = "input-telephone")
  WebElement telephoneField;

  @FindBy(id = "input-password")
  WebElement passwordField;

  @FindBy(id = "input-confirm")
  WebElement passwordConfirmField;

  @FindBy(linkText = "Privacy Policy")
  WebElement privacyPolicy;

  @FindBy(className = "close")
  WebElement privacyPolicyClose;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
  WebElement privacyPolicyCheck;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
  WebElement buttonContinue;

  @FindBy(id = "content")
  WebElement signUpSuccessMessage;

  @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")
  WebElement signUpFailedMessage;

  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  public WebElement getSignUpSuccessMessage() {
    return signUpSuccessMessage;
  }

  public WebElement getSignUpFailedMessage() {
    return signUpFailedMessage;
  }

  public void signUp(String fName, String lName, String telephone, String pswd,
                     String pswdConfirm) {
    firstNameField.sendKeys(fName);
    lastNameField.sendKeys(lName);
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(10000);
    emailField.sendKeys(fName + randomInt + "@gmail.com");
    telephoneField.sendKeys(telephone);
    passwordField.sendKeys(pswd);
    passwordConfirmField.sendKeys(pswdConfirm);
    privacyPolicyCheck.click();
    buttonContinue.click();
  }

  public void signUpWithPpCheck(String fName, String lName, String telephone,
                                String pswd, String pswdConfirm) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    firstNameField.sendKeys(fName);
    lastNameField.sendKeys(lName);
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(10000);
    emailField.sendKeys(fName + randomInt + "@gmail.com");
    telephoneField.sendKeys(telephone);
    passwordField.sendKeys(pswd);
    passwordConfirmField.sendKeys(pswdConfirm);
    privacyPolicy.click();
    privacyPolicyClose.click();
    privacyPolicyCheck.click();
    buttonContinue.click();
  }
}
