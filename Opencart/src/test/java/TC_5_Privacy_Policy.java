import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Opencart WebApplication Interactions")
public class TC_5_Privacy_Policy extends BaseTest {

  @Test
  @Feature("Registration")
  @Story("Successful Registration")
  @DisplayName("Successful user account registration with use privacy statement")
  @Description("This test is make a success register with valid values, and with open the privacy policy")
  public void signUpWithPpCheck() {
    HomePage homePage = new HomePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openRegisterPage();
    registerPage.isLoaded();

    registerPage.signUpWithPpCheck("Trefa",
        "Bela",
        "2132131",
        "asddsa",
        "asddsa");
    registerPage.signUpSuccessfully();
  }
}
