package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesktopsPage extends BasePage {
  private static final Logger LOG = LoggerFactory.getLogger(DesktopsPage.class);

  @FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[1]/ul/li[2]/a")
  WebElement pagingToPage2;

  public DesktopsPage() {
  }

  public DesktopsPage(WebDriver driver) {
    super(driver);
  }

  @Step("Show all desktops page 1 should load successfully")
  public boolean isLoaded() {
    LOG.info("Show all desktops page 1 loaded success");
    return driver.getCurrentUrl()
        .equals("http://test-automation-shop2.greenfox.academy/desktops");
  }

  @Step("This step is should to open the desktops page 2")
  public void paging() {
    pagingToPage2.click();
  }

}
