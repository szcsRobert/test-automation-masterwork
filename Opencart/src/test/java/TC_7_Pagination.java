import static org.assertj.core.api.Assertions.assertThat;


import Pages.DesktopsPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Pagination")
public class TC_7_Pagination extends BaseTest {

  @Test
  @DisplayName("Navigate between pages")
  @Description("Navigate from one full page result list to another")
  public void PaginationTest() {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    DesktopsPage desktopsPage = PageFactory.initElements(driver, DesktopsPage.class);

    homePage.openDesktopsPage();
    assertThat(driver.getTitle()).isEqualTo("Desktops");
    desktopsPage.pagination();

    makeScreenshot();
    assertThat(driver.findElement(By.linkText("Dell Inspiron 4563")).isDisplayed()).isTrue();
  }
}
