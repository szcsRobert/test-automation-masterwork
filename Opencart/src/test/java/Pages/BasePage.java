package Pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

public class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Logger LOG;

  public BasePage() {
    this.driver = new ChromeDriver();
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //this.LOG = LoggerFactory.getLogger(cls);
    PageFactory.initElements(driver, this);
  }

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    // this.LOG = LoggerFactory.getLogger(cls);
    PageFactory.initElements(driver, this);
  }
}
