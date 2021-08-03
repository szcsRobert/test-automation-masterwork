package Pages;

import io.qameta.allure.Step;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesktopsPage extends BasePage {
  private static final Logger LOG = LoggerFactory.getLogger(DesktopsPage.class);

  @FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[1]/ul/li[2]/a")
  WebElement pagingToPage2;

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
  public void pagination() {
    LOG.info("Show all desktops page 2 loaded success");
    pagingToPage2.click();

    List<WebElement> pagination =
        driver.findElements(By.xpath("//*[@id=\"content\"]/div[5]/div[1]/ul"));

    if (pagination.size() > 0) {
      System.out.println("pagination exists");
      for (int i = 0; i < pagination.size(); i++) {
        pagination.get(i).click();
      }
    } else {
      System.out.println("pagination not exists");
    }
  }

  public List<WebElement> getListOfProducts() {
    return driver
        .findElements(By.xpath("//*[@id=\"content\"]/div[4]/div[*]/div/div[2]/div[1]/h4/a"));
  }

  @Step("This step save the products name")
  public void saveProductsName() {

    String file = "src/test/resources/listOfProductsName.txt";
    Path filePath = Paths.get(file);

    List<String> productsList = new ArrayList<>();

    try {
      Files.write(filePath, productsList);
    } catch (IOException e) {
      System.out.println("Cannot write the file");
    }
    for (WebElement eachProduct : getListOfProducts()) {
      productsList.add(eachProduct.getText());
    }
    try {
      Files.write(filePath, productsList);
    } catch (IOException e) {
      System.out.println("Cannot write the file");
    }
  }
}
