import static org.assertj.core.api.Assertions.assertThat;


import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Listing Data")
public class TC_6_Listing_Data extends BaseTest {

  @Test
  @DisplayName("This should list cameras")
  @Description("This test is make a success data listing with the category of cameras")
  public void listingCamerasData() {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    homePage.getCamerasPage().click();
    makeScreenshot();
    assertThat(driver.findElement(By.linkText("Canon EOS 5D")).isDisplayed()).isTrue();
  }
}
