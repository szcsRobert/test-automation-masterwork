package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

  private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
  WebElement myAccount;

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
  WebElement myAccountRegister;

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
  WebElement myAccountLogin;

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
  WebElement myAccountLogout;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[7]/a")
  WebElement categoryCameras;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
  WebElement categoryDesktops;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
  WebElement categoryDesktopsShowAll;

  @FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[1]/a")
  WebElement contactUsPage;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  @Step("Your Store should open")
  public void open() {
    LOG.info("Your Store is opened");
    driver.get("http://test-automation-shop2.greenfox.academy");
  }

  @Step("The home page should load successfully")
  public boolean isLoaded() {
    LOG.info("The home page loaded success");
    return driver.getCurrentUrl().equals("http://test-automation-shop2.greenfox.academy");
  }

  @Step("The registration page should open")
  public void openRegisterPage() {
    LOG.info("The registration page loaded success");
    myAccount.click();
    myAccountRegister.click();
  }

  @Step("The login page should open")
  public void openLoginPage() {
    LOG.info("The login page loaded success");
    myAccount.click();
    myAccountLogin.click();
  }

  @Step("The logout should logout the user")
  public void myAccountLogout() {
    LOG.info("The logout is success");
    myAccount.click();
    myAccountLogout.click();
  }

  @Step("The category of cameras page should open")
  public void openCamerasPage() {
    LOG.info("The category of cameras page loaded success");
    categoryCameras.click();
  }

  @Step("Show all desktops page should open")
  public void openDesktopsPage() {
    LOG.info("Show all desktops page loaded success");
    categoryDesktops.click();
    categoryDesktopsShowAll.click();
  }

  @Step("Contact us page should open")
  public void openContactUsPage() {
    LOG.info("Contact us page load is success");
    contactUsPage.click();
  }
}
