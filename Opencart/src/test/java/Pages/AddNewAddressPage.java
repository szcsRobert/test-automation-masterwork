package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewAddressPage extends AddressPage {

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

  public AddNewAddressPage(WebDriver driver) {
    super(driver);
  }

  public void newAddress(String fName, String lName, String address, String city,
                         String postCode, String country) {
    firstnameField.sendKeys(fName);
    lastnameField.sendKeys(lName);
    addressField.sendKeys(address);
    cityField.sendKeys(city);
    postcodeField.sendKeys(postCode);
    Select select = new Select(countryField);
    select.selectByVisibleText(country);
    continueButton.click();
  }
}
