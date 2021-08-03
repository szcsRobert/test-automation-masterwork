package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamerasPage extends BasePage {

  private static final Logger LOG = LoggerFactory.getLogger(CamerasPage.class);

  @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[1]/h4/a")
  WebElement targetCanonEos5D;

  public CamerasPage(WebDriver driver) {
    super(driver);
  }

  @Step("Category of cameras page should load successfully")
  public boolean isLoaded() {
    LOG.info("Category of cameras  page loaded success");
    return driver.getCurrentUrl()
        .equals("http://test-automation-shop2.greenfox.academy/camera");
  }

  @Step("This step should check the first target on the loaded page")
  public boolean checkCanonEos5D() {
    LOG.info("The first target is Canon EOS 5D");
    return targetCanonEos5D.getText().equals("Canon EOS 5D");
  }
}
