import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Properties properties;

  @BeforeEach
  public void setup() throws IOException {
    String browser;
    loadProperties();

    browser = properties.getProperty("browser");

    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      this.driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      this.driver = new FirefoxDriver();
    } else {
      WebDriverManager.edgedriver().setup();
      this.driver = new EdgeDriver();
    }
    wait = new WebDriverWait(driver, 5);
    driver.manage().window().maximize();
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  private void loadProperties() throws IOException {
    properties = new Properties();

    properties.load(getClass().getResourceAsStream("/test.properties"));
  }

}
