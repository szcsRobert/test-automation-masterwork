package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddNewAddressPage extends AddressPage {

  private static final Logger LOG = LoggerFactory.getLogger(AddNewAddressPage.class);

  @FindBy(id = "input-firstname")
  WebElement firstnameField;

  @FindBy(id = "input-lastname")
  WebElement lastnameField;

  @FindBy(id = "input-address-1")
  WebElement addressField;

  @FindBy(id = "input-city")
  WebElement cityField;

  @FindBy(id = "input-postcode")
  WebElement postcodeField;

  @FindBy(id = "input-country")
  WebElement countryField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement continueButton;

  public AddNewAddressPage() {
  }

  public AddNewAddressPage(WebDriver driver) {
    super(driver);
  }


  @Step("Add new address page should load successfully")
  public boolean isLoaded() {
    LOG.info("Add new address page loaded success");
    return driver.getCurrentUrl()
        .equals(
            "http://test-automation-shop2.greenfox.academy/index.php?route=account/address/add");
  }

  public void newAddress(String fName, String lName, String address, String city,
                         String postCode, String country) {
    LOG.info("newAddress() called");
    LOG.trace("firstname=" + fName + "lastname=" + lName);
    firstnameField.sendKeys(fName);
    lastnameField.sendKeys(lName);
    LOG.trace("address=" + address);
    addressField.sendKeys(address);
    LOG.trace("city=" + city);
    cityField.sendKeys(city);
    LOG.trace("postcode=" + postCode);
    postcodeField.sendKeys(postCode);
    LOG.trace("country=" + country);
    Select select = new Select(countryField);
    select.selectByVisibleText(country);
    LOG.debug("Click Continue");
    continueButton.click();
  }

}
