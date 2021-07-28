package Pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactUsPage extends BasePage {
  private static final Logger LOG = LoggerFactory.getLogger(ContactUsPage.class);

  @FindBy(id = "input-name")
  WebElement nameField;

  @FindBy(id = "input-email")
  WebElement emailField;

  @FindBy(id = "input-enquiry")
  WebElement enquiryField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input")
  WebElement submit;

  public ContactUsPage() {
  }

  public ContactUsPage(WebDriver driver) {
    super(driver);
  }

  @Step("The contact us page should open")
  public boolean isLoaded() {
    LOG.info("Contact us page is loaded successfully");
    return driver.getCurrentUrl()
        .equals(
            "http://test-automation-shop2.greenfox.academy/index.php?route=information/contact");
  }

  public void contact(String name, String email, String enquiry) {
    LOG.info("contact() called");
    LOG.trace("name=" + name);
    nameField.sendKeys(name);
    LOG.trace("email=" + email);
    emailField.sendKeys(email);
    LOG.trace("enquiry=" + enquiry);
    enquiryField.sendKeys(enquiry);
    LOG.debug("Click on submit");
    submit.click();
  }
}
