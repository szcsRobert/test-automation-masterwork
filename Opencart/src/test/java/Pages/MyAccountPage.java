package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccountPage extends BasePage {

  private static final Logger LOG = LoggerFactory.getLogger(MyAccountPage.class);

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
  WebElement myAccount;

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
  WebElement myAccountLogout;

  @FindBy(xpath = "//*[@id=\"content\"]/ul[1]/li[3]/a")
  WebElement modifyYourAddress;

  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  @Step("My Account page should load successfully")
  public boolean isLoaded() {
    LOG.info("My Account page loaded success");
    return driver.getCurrentUrl()
        .equals("http://test-automation-shop2.greenfox.academy/index.php?route=account/account");
  }

  @Step("Modify your address book entries should open")
  public void openModifyYourAdress() {
    LOG.info("Modify your address book entries page is loaded");
    modifyYourAddress.click();
  }

  @Step("This step is logout the user after a success login")
  public void shouldLogout() {
    LOG.info("Logout the user after a success login");
    myAccount.click();
    myAccountLogout.click();
  }
}
