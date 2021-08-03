package Pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import io.qameta.allure.Step;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterPage extends BasePage {

  private static final Logger LOG = LoggerFactory.getLogger(RegisterPage.class);

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

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/a/b")
  WebElement privacyPolicy;

  @FindBy(xpath = "//*[@id=\"modal-agree\"]/div/div/div[1]/button")
  WebElement privacyPolicyClose;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
  WebElement privacyPolicyCheck;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
  WebElement buttonContinue;

  @FindBy(css = "#content > p:nth-child(2)")
  WebElement signUpSuccess;

  @FindBy(css = "#content > form > fieldset:nth-child(2) > div.form-group.required.has-error > div > div")
  WebElement signUpFailed;

  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  @Step("The registration page should load successfully")
  public boolean isLoaded() {
    LOG.info("The registration page loaded success");
    return driver.getCurrentUrl()
        .equals("http://test-automation-shop2.greenfox.academy/index.php?route=account/register");
  }

  @Step("The sign up should success")
  public void signUpSuccessfully() {
    LOG.info("Check sign up page is loaded success");
    assertThat(signUpSuccess.getText())
        .isEqualTo("Congratulations! Your new account has been successfully created!");
  }

  @Step("The sign up should unsuccess")
  public void signUpFailed() {
    LOG.info("Check sign up page is loaded with warning");
    assertThat(signUpFailed.isDisplayed());
  }

  public void signUp(String fName, String lName, String telephone, String pswd,
                     String pswdConfirm) {
    LOG.info("signUp() called");
    LOG.trace("firstname=" + fName + "lastname=" + lName);
    firstNameField.sendKeys(fName);
    lastNameField.sendKeys(lName);
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);
    LOG.trace("email=" + fName + randomInt + "@gmail.com");
    emailField.sendKeys(fName + randomInt + "@gmail.com");
    LOG.trace("phonenumber=" + telephone);
    telephoneField.sendKeys(telephone);
    LOG.trace("password=" + pswd);
    passwordField.sendKeys(pswd);
    passwordConfirmField.sendKeys(pswdConfirm);
    LOG.debug("Check the box");
    privacyPolicyCheck.click();
    LOG.debug("Click on submit");
    buttonContinue.click();
  }

  public void signUpWithPpCheck(String fName, String lName, String telephone,
                                String pswd, String pswdConfirm) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    LOG.info("signUp() called");
    LOG.trace("firstname=" + fName + "lastname=" + lName);
    firstNameField.sendKeys(fName);
    lastNameField.sendKeys(lName);
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);
    LOG.trace("email=" + fName + randomInt + "@gmail.com");
    emailField.sendKeys(fName + randomInt + "@gmail.com");
    LOG.trace("phonenumber=" + telephone);
    telephoneField.sendKeys(telephone);
    LOG.trace("password=" + pswd);
    passwordField.sendKeys(pswd);
    passwordConfirmField.sendKeys(pswdConfirm);
    LOG.debug("Open the policy");
    privacyPolicy.click();
    LOG.debug("Close the policy");
    privacyPolicyClose.click();
    LOG.debug("Check the box");
    privacyPolicyCheck.click();
    LOG.debug("Click on submit");
    buttonContinue.click();
  }
}
