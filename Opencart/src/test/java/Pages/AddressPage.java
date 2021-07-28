package Pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressPage extends MyAccountPage {
  private static final Logger LOG = LoggerFactory.getLogger(AddressPage.class);

  @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[3]/td[2]/a[2]")
  WebElement deleteAddressButton;

  @FindBy(css = "#account-address > div.alert.alert-success.alert-dismissible")
  WebElement deleteAddressSuccess;

  @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/a")
  WebElement newAddressButton;

  @FindBy(css = "#account-address > div.alert.alert-success.alert-dismissible")
  WebElement newAddressSuccess;

  public AddressPage() {
  }

  public AddressPage(WebDriver driver) {
    super(driver);
  }

  @Step("Address page should load successfully")
  public boolean isLoaded() {
    LOG.info("Address page loaded success");
    return driver.getCurrentUrl()
        .equals("http://test-automation-shop2.greenfox.academy/index.php?route=account/address");
  }

  @Step("Add new address page should open")
  public void openNewAddress() {
    LOG.info("Add new address page is opened");
    newAddressButton.click();
  }

  @Step("This step should delete an exist address")
  public void deleteAddress() {
    LOG.info("This step deleted an exist address");
    deleteAddressButton.click();
  }

  @Step("This step should add new address")
  public void newAddressSuccess() {
    LOG.info("The address is added");
    assertThat(newAddressSuccess.getText())
        .isEqualTo("Your address has been successfully added");
  }

  @Step("This step should delete exist address")
  public void deleteAddressSuccess() {
    LOG.info("The address is deleted");
    assertThat(deleteAddressSuccess.getText())
        .isEqualTo("Your address has been successfully deleted");
  }
}
