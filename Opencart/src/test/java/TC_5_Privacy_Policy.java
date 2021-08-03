import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store")
public class TC_5_Privacy_Policy extends BaseTest {

  @Test
  @Feature("Register with Privacy Policy check")
  @DisplayName("This should sign up with privacy policy")
  @Description("This test is make a success register with valid values, and with open the privacy policy")
  public void signUpWithPpCheck() throws InterruptedException {
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
