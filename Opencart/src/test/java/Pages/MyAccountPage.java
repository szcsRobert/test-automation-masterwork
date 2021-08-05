package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

  @FindBy(xpath = "//*[@id=\"content\"]/ul[1]/li[3]/a")
  WebElement modifyYourAddress;

  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  public WebElement openModifyYourAddress() {
    return modifyYourAddress;
  }
}
