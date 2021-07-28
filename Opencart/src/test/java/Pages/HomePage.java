package Pages;

import static org.assertj.core.api.Assertions.assertThat;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
  WebDriver driver;
  WebDriverWait wait;
  // private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
  WebElement myAccount;

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
  WebElement myAccountRegister;

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
  WebElement getPrivacyPolicyClose;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
  WebElement privacyPolicyCheck;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
  WebElement buttonContinue;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void open() {
    driver.get("http://test-automation-shop2.greenfox.academy");
    LOG.info("Opening the HomePage...");


    assertThat(driver.getTitle()).isEqualTo("Your Store");
    LOG.info("HomePage is loaded successfully");
  }

  @Step("The page should load successfully")
  public boolean isLoaded() {
    return driver.getCurrentUrl().equals("http://test-automation-shop2.greenfox.academy");
    LOG.info("The page is loaded successfully");
  }

  @Step("The sign up should success")
  public boolean signUpSucessfully() {
    return driver.getCurrentUrl()
        .equals("http://test-automation-shop2.greenfox.academy/index.php?route=account/success");
    //LOG.info("The sign up is success");
  }

  public void signUp(String fName, String lName, String email, String telephone, String pswd) {
    myAccount.click();
    myAccountRegister.click();
    LOG.info("signUp() called");
    LOG.trace("firstname=" + fName + "lastname=" + lName);
    firstNameField.sendKeys(fName);
    lastNameField.sendKeys(lName);
    LOG.trace("email=" + email);
    emailField.sendKeys(email);
    LOG.trace("phonenumber=" + telephone);
    telephoneField.sendKeys(telephone);
    LOG.trace("password=" + pswd);
    passwordField.sendKeys(pswd);
    passwordConfirmField.sendKeys(pswd);
    LOG.debug("Check the box");
    privacyPolicyCheck.click();
    LOG.debug("Click on submit");
    buttonContinue.click();
  }

}
