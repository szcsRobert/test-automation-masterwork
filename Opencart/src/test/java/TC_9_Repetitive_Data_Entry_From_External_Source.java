import Pages.AddNewAddressPage;
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
public class TC_9_Repetitive_Data_Entry_From_External_Source extends BaseTest {

  @Test
  @Feature("Add new addresses")
  @DisplayName("This should add some new address")
  @Description("This test is add some new address")
  public void addNewAddresses() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    AddressPage addressPage = new AddressPage(driver);
    AddNewAddressPage addNewAddressPage = new AddNewAddressPage(driver);

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
    addressPage.addNewAddress();

    addNewAddressPage.newAddress("Peter",
        "Proba",
        "Kiss Sandor utca 4.",
        "Budapest",
        "1138",
        "Hungary");
    addressPage.newAddressSuccess();
  }
}
