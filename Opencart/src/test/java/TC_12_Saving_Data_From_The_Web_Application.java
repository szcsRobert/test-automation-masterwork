import Pages.DesktopsPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Saving datas")
public class TC_12_Saving_Data_From_The_Web_Application extends BaseTest {

  @Test
  @DisplayName("Saving data from the web application")
  @Description("Save the list of products on the first page")
  public void saveDatas() {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    DesktopsPage desktopsPage = PageFactory.initElements(driver, DesktopsPage.class);

    homePage.openDesktopsPage();

    desktopsPage.saveProductsName();
  }
}
