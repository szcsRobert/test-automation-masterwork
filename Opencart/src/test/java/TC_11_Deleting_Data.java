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

@Epic("Your Store")
public class TC_11_Deleting_Data extends BaseTest {

  @Test
  @Feature("Deleting data")
  @DisplayName("This should delete an existing data")
  @Description("This test is deleted an address in the address book entries of the user")
  public void deleting_data() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    AddressPage addressPage = new AddressPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openLoginPage();
    loginPage.isLoaded();

    loginPage.login("probapet@gmail.com",
        "asddsa");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    myAccountPage.isLoaded();

    myAccountPage.openModifyYourAdress();
    addressPage.isLoaded();
    addressPage.deleteAddress();
    addressPage.deleteAddressSuccess();
  }
}
