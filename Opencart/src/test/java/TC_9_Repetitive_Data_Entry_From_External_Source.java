import static org.assertj.core.api.Assertions.assertThat;


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
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Repetitive data entry")
public class TC_9_Repetitive_Data_Entry_From_External_Source extends BaseTest {

  @ParameterizedTest(name = "Input Value = Name: {1} {0} Address: {4} {3}, {2} {5}")
  @CsvFileSource(resources = "/newAddresses.csv", numLinesToSkip = 1, encoding = "utf-8")
  @DisplayName("Add new address")
  @Description("Add new addresses from an external file")
  public void addNewAddresses(String fName, String lName, String address, String city,
                              String postCode, String country) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    AddressPage addressPage = PageFactory.initElements(driver, AddressPage.class);
    AddNewAddressPage addNewAddressPage = PageFactory.initElements(driver, AddNewAddressPage.class);
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

    homePage.openLoginPage();

    loginPage.login("probapet@gmail.com", "asddsa");

    myAccountPage.openModifyYourAddress().click();

    addressPage.addNewAddressButton().click();

    addNewAddressPage.newAddress(fName, lName, address, city, postCode, country);

    makeScreenshot();
    assertThat(addressPage.newAddressSuccess().getText())
        .isEqualTo("Your address has been successfully added");
    homePage.myAccountLogout();
  }
}
