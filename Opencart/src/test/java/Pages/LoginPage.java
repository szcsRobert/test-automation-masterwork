package Pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends HomePage {
  private static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);

  @FindBy(id = "input-email")
  WebElement emailField;

  @FindBy(id = "input-password")
  WebElement passwordField;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
  WebElement buttonLogin;

  @FindBy(xpath = "//*[@id=\"content\"]/h2[1]")
  WebElement loginSuccess;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
  WebElement loginFailed;


  public LoginPage() {
  }

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Step("The login page should load successfully")
  public boolean isLoaded() {
    LOG.info("The login page loaded success");
    return driver.getCurrentUrl()
        .equals("http://test-automation-shop2.greenfox.academy/index.php?route=account/login");
  }

  @Step("The login should success")
  public void loginSuccessfully() {
    LOG.info("Check login page is loaded success");
    assertThat(loginSuccess.getText())
        .isEqualTo("My Account");
  }

  @Step("The login should unsuccess")
  public void loginFailed() {
    LOG.info("Check login page is loaded with warning");
    assertThat(loginFailed.isDisplayed());
  }

  public void login(String email, String password) {
    LOG.info("login() called");
    LOG.trace("email=" + email);
    emailField.sendKeys(email);
    LOG.trace("password=" + password);
    passwordField.sendKeys(password);
    LOG.debug("Click on submit");
    buttonLogin.click();
  }
}
