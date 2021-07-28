import Pages.ContactUsPage;
import Pages.ContactUsSuccessPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store")
public class TC_8_Input_Of_New_Data extends BaseTest {

  @Test
  @Feature("Input new data")
  @DisplayName("This should contact with support")
  @Description("This test is sending a complaint to the support")
  public void listingCamerasData() {
    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    ContactUsSuccessPage contactUsSuccessPage = new ContactUsSuccessPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openContactUsPage();
    contactUsPage.isLoaded();
    contactUsPage.contact("Peter Proba",
        "probapet@gmail.com",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi" +
            " ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit" +
            " in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
            "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

    contactUsSuccessPage.contactUsWasSuccessfull();
  }
}
