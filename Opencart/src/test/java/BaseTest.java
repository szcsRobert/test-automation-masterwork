import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Properties properties;
  protected static Logger LOG = LoggerFactory.getLogger(BaseTest.class);


  @BeforeEach
  public void setup() throws IOException {
    String browser;
    LOG.info("Set browser");
    Properties properties = new Properties();
    InputStream propertiesStream = this.getClass().getResourceAsStream("/test.properties");
    properties.load(propertiesStream);
    browser = properties.getProperty("browser");

    if (browser.equals("chrome")) {
      //load chromedriver
      WebDriverManager.chromedriver().setup();
      this.driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      this.driver = new FirefoxDriver();
    } else  {
      WebDriverManager.edgedriver().setup();
      this.driver = new EdgeDriver();
    }
    driver.manage().window().maximize();
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }
}
