import Pages.AddNewAddressPage;
import Pages.AddressPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("Opencart WebApplication Interactions")
public class TC_9_Repetitive_Data_Entry_From_External_Source extends BaseTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/newAddresses.csv", numLinesToSkip = 1, encoding = "utf-8")
  @Feature("Repetitive data entry")
  @DisplayName("Add new address")
  @Description("Add new addresses from an external file")
  public void addNewAddresses(String fName, String lName, String address, String city,
                              String postCode, String country) {

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

    addNewAddressPage.newAddress(fName, lName, address, city, postCode, country);
    addressPage.newAddressSuccess();
    myAccountPage.shouldLogout();
  }
}
