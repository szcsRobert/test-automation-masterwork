package Pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutPage extends BasePage {
  private static final Logger LOG = LoggerFactory.getLogger(LogoutPage.class);

  @FindBy(xpath = "//*[@id=\"content\"]/h1")
  WebElement logoutSuccess;

  public LogoutPage() {
  }

  public LogoutPage(WebDriver driver) {
    super(driver);
  }

  @Step("The logout should success")
  public void logoutSuccessfully() {
    LOG.info("Check the logout was success");
    assertThat(logoutSuccess.getText())
        .isEqualTo("Account Logout");
  }
}
