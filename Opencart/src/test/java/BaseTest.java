import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

  WebDriver driver;
  WebDriverWait wait;
  Properties properties;
  static Logger LOG = LoggerFactory.getLogger(BaseTest.class);


  @BeforeAll
  public void setup() throws IOException {

    String browser;

    LOG.info("Set browser");

    properties = new Properties();
    InputStream propertiesStream = this.getClass().getResourceAsStream("/test.properties");
    properties.load(propertiesStream);
    browser = properties.getProperty("browser");

    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    } else {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    }
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    LOG.info("Maximize window");
    driver.manage().window().maximize();
  }

  @AfterAll
  public void tearDown() {
    LOG.info("Close window");
    driver.quit();
  }
}
