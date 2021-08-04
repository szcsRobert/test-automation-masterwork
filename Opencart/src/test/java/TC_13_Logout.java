import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Opencart WebApplication Interactions")
public class TC_13_Logout extends BaseTest {

  @Test
  @Feature("Logout")
  @DisplayName("This should logout the user")
  @Description("Successfully logged out with a previously logged in user")
  public void logout() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    LogoutPage logoutPage = new LogoutPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openLoginPage();
    loginPage.isLoaded();

    loginPage.login("probapet@gmail.com",
        "asddsa");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    myAccountPage.isLoaded();

    homePage.myAccountLogout();
    logoutPage.logoutSuccessfully();
  }
}
