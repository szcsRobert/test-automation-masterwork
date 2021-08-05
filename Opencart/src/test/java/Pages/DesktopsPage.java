package Pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DesktopsPage extends BasePage {

  public DesktopsPage(WebDriver driver) {
    super(driver);
  }

  public void pagination() {
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
