package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends MyAccountPage {

  @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[2]/td[2]/a[1]")
  WebElement editAddressButton;

  @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[3]/td[2]/a[2]")
  WebElement deleteAddressButton;

  @FindBy(css = "#account-address > div.alert.alert-success.alert-dismissible")
  WebElement deleteAddressSuccess;

  @FindBy(css = "#account-address > div.alert.alert-success.alert-dismissible")
  WebElement editAddressSuccess;

  @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/a")
  WebElement newAddressButton;

  @FindBy(css = "#account-address > div.alert.alert-success.alert-dismissible")
  WebElement newAddressSuccess;

  public AddressPage(WebDriver driver) {
    super(driver);
  }

  public WebElement editAddressButton() {
    return editAddressButton;
  }

  public WebElement deleteAddressButton() {
    return deleteAddressButton;
  }

  public WebElement addNewAddressButton() {
    return newAddressButton;
  }

  public WebElement editAddressSuccess() {
    return editAddressSuccess;
  }

  public WebElement deleteAddressSuccess() {
    return deleteAddressSuccess;
  }

  public WebElement newAddressSuccess() {
    return newAddressSuccess;
  }
}
