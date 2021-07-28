import Pages.CamerasPage;
import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store")
public class TC_6_Listing_Data extends BaseTest {

  @Test
  @Feature("Listing Data")
  @DisplayName("This should list cameras")
  @Description("This test is make a success data listing with the category of cameras")
  public void listingCamerasData() {
    HomePage homePage = new HomePage(driver);
    CamerasPage camerasPage = new CamerasPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openCamerasPage();
    camerasPage.isLoaded();
    camerasPage.checkCanonEos5D();

  }

}
