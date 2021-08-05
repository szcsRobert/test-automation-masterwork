import static org.assertj.core.api.Assertions.assertThat;


import Pages.AddressPage;
import Pages.EditAddressPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Existing data modification")
public class TC_10_Existing_Data_Modification extends BaseTest {

  @Test
  @DisplayName("Change mailing address")
  @Description("This test is modified an address of the user")
  public void modifyExistingData() {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    AddressPage addressPage = PageFactory.initElements(driver, AddressPage.class);
    EditAddressPage editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);

    homePage.openLoginPage();

    loginPage.login("probapet@gmail.com", "asddsa");

    myAccountPage.openModifyYourAddress().click();
    addressPage.editAddressButton().click();

    editAddressPage.modifyFirstName("Patrik");
    makeScreenshot();
    assertThat(addressPage.editAddressSuccess().getText())
        .isEqualTo("Your address has been successfully updated");
  }
}
