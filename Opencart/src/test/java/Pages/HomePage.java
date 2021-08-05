package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
  WebElement myAccount;

  @FindBy(linkText = "Register")
  WebElement myAccountRegister;

  @FindBy(linkText = "Login")
  WebElement myAccountLogin;

  @FindBy(linkText = "Logout")
  WebElement myAccountLogout;

  @FindBy(linkText = "Cameras")
  WebElement categoryCameras;

  @FindBy(linkText = "Desktops")
  WebElement categoryDesktops;

  @FindBy(linkText = "Show All Desktops")
  WebElement categoryDesktopsShowAll;

  @FindBy(linkText = "Contact Us")
  WebElement contactUsPage;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void openRegisterPage() {
    myAccount.click();
    myAccountRegister.click();
  }

  public void openLoginPage() {
    myAccount.click();
    wait.until(ExpectedConditions.elementToBeClickable(myAccountLogin));
    myAccountLogin.click();
  }

  public void myAccountLogout() {
    myAccount.click();
    myAccountLogout.click();
  }

  public WebElement getCamerasPage() {
    return categoryCameras;
  }

  public void openDesktopsPage() {
    categoryDesktops.click();
    categoryDesktopsShowAll.click();
  }

  public WebElement getContactUsPage() {
    return contactUsPage;
  }
}
