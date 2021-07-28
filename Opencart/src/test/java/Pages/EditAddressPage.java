package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditAddressPage extends AddressPage {
  private static final Logger LOG = LoggerFactory.getLogger(EditAddressPage.class);

  @FindBy(id = "input-firstname")
  WebElement editFirstNameField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement continueButton;

  public EditAddressPage() {
  }

  public EditAddressPage(WebDriver driver) {
    super(driver);
  }

  @Step("Edit address page should load successfully")
  public boolean isLoaded() {
    LOG.info("Edit address page loaded success");
    return driver.findElement(By.id("content")).getText()
        .equals("Edit Address");
  }

  @Step("First Name should modified")
  public void modifyFirstName(String fName) {
    LOG.info("First Name is modified");
    editFirstNameField.clear();
    editFirstNameField.sendKeys(fName);
    continueButton.click();
  }
}
