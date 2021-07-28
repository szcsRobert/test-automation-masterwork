package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactUsSuccessPage extends ContactUsPage {
  private static final Logger LOG = LoggerFactory.getLogger(ContactUsSuccessPage.class);

  public ContactUsSuccessPage() {
  }

  public ContactUsSuccessPage(WebDriver driver) {
    super(driver);
  }

  @Step("This step should do a contact with support")
  public boolean contactUsWasSuccessfull() {
    LOG.info("Message has been sended to the support");
    return driver.getCurrentUrl()
        .equals(
            "http://test-automation-shop2.greenfox.academy/index.php?route=information/contact/success");
  }
}
