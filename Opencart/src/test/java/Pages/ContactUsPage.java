package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

  @FindBy(id = "input-name")
  WebElement nameField;

  @FindBy(id = "input-email")
  WebElement emailField;

  @FindBy(id = "input-enquiry")
  WebElement enquiryField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input")
  WebElement submit;

  public ContactUsPage(WebDriver driver) {
    super(driver);
  }

  public void contact(String name, String email, String enquiry) {
    nameField.sendKeys(name);
    emailField.sendKeys(email);
    enquiryField.sendKeys(enquiry);
    submit.click();
  }
}
