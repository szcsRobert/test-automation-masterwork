import static org.assertj.core.api.Assertions.assertThat;


import Pages.AddressPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Deleting data")
public class TC_11_Deleting_Data extends BaseTest {

  @Test
  @DisplayName("Delete mailing address")
  @Description("This test is deleted an address in the address book entries of the user")
  public void deletingData() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    AddressPage addressPage = PageFactory.initElements(driver, AddressPage.class);

    homePage.openLoginPage();

    loginPage.login("probapet@gmail.com",
        "asddsa");

    myAccountPage.openModifyYourAddress().click();
    addressPage.deleteAddressButton().click();
    makeScreenshot();
    assertThat(addressPage.deleteAddressSuccess().getText())
        .isEqualTo("Your address has been successfully deleted");
  }
}
