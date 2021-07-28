import Pages.AddressPage;
import Pages.EditAddressPage;
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
public class TC_10_Existing_Data_Modification extends BaseTest {

  @Test
  @Feature("Existing data modification")
  @DisplayName("This should modified an existing data")
  @Description("This test is modified an address in the of the user")
  public void modifyExistingData() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    AddressPage addressPage = new AddressPage(driver);
    EditAddressPage editAddressPage = new EditAddressPage(driver);

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
    addressPage.editExistingAddress();

    editAddressPage.modifyFirstName("Patrik");
    addressPage.editAddressSuccess();
  }
}
