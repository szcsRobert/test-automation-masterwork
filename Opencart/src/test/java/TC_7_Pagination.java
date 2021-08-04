import Pages.DesktopsPage;
import Pages.DesktopsPage2;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Opencart WebApplication Interactions")
public class TC_7_Pagination extends BaseTest {

  @Test
  @Feature("Pagination")
  @DisplayName("Navigate between pages")
  @Description("Navigate from one full page result list to another")
  public void listingCamerasData() {
    HomePage homePage = new HomePage(driver);
    DesktopsPage desktopsPage = new DesktopsPage(driver);
    DesktopsPage2 desktopsPage2 = new DesktopsPage2(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openDesktopsPage();
    desktopsPage.isLoaded();
    desktopsPage.pagination();

    desktopsPage2.pagingSuccessfully();
  }
}
