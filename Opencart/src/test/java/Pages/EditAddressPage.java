package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAddressPage extends AddressPage {

  @FindBy(id = "input-firstname")
  WebElement editFirstNameField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement continueButton;

  public EditAddressPage(WebDriver driver) {
    super(driver);
  }

  public void modifyFirstName(String fName) {
    editFirstNameField.clear();
    editFirstNameField.sendKeys(fName);
    continueButton.click();
  }
}
