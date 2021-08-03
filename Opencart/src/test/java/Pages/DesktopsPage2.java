package Pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesktopsPage2 extends DesktopsPage {

  private static final Logger LOG = LoggerFactory.getLogger(DesktopsPage2.class);

  @FindBy(xpath = "//*[@id=\"content\"]/div[4]/div/div/div[2]/div[1]/h4/a")
  WebElement successPage2;

  public DesktopsPage2(WebDriver driver) {
    super(driver);
  }

  @Step("The page 2 should open success")
  public void pagingSuccessfully() {
    LOG.info("Desktops page 2 is loaded success");
    assertThat(successPage2.isDisplayed());
  }
}
