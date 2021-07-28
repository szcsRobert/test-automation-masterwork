import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store")
public class TC_13_Logout extends BaseTest {

  @Test
  @Feature("Logout")
  @DisplayName("This should logout the user")
  @Description("This test is logout the user after login")
  public void logout() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    LogoutPage logoutPage = new LogoutPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openLoginPage();
    loginPage.isLoaded();

    loginPage.login("probapet@gmail.com",
        "asddsa");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    loginPage.loginSuccessfully();

    homePage.myAccountLogout();
    logoutPage.logoutSuccessfully();
  }
}
