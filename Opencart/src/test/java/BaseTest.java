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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  WebDriver driver;
  WebDriverWait wait;
  Properties properties;

  @BeforeAll
  public void setup() throws IOException {
    String browser;

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
  }

  @BeforeEach
  public void openHomePage() {
    driver.get("http://test-automation-shop2.greenfox.academy");
    wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    driver.manage().window().maximize();
  }

  @AfterAll
  public void tearDown() {
    driver.quit();
  }
}
