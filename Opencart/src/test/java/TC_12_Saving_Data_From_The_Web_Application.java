import Pages.DesktopsPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Opencart WebApplication Interactions")
public class TC_12_Saving_Data_From_The_Web_Application extends BaseTest {

  @Test
  @Feature("Saving datas")
  @DisplayName("Saving data from the web application")
  @Description("Save the list of products on the first page")
  public void saveDatas() {
    HomePage homePage = new HomePage(driver);
    DesktopsPage desktopsPage = new DesktopsPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openDesktopsPage();
    desktopsPage.isLoaded();

    desktopsPage.saveProductsName();
  }
}
