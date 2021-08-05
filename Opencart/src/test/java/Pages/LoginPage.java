package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {

  @FindBy(id = "input-email")
  WebElement emailField;

  @FindBy(id = "input-password")
  WebElement passwordField;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
  WebElement buttonLogin;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
  WebElement loginFailed;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public WebElement getLoginFailed() {
    return loginFailed;
  }

  public void login(String email, String password) {
    emailField.sendKeys(email);
    passwordField.sendKeys(password);
    buttonLogin.click();
  }
}
