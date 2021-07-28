import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store")
public class TC_3_4_Login extends BaseTest {

  @Test
  @Feature("Login")
  @DisplayName("This should login with a user")
  @Description("This test is make a success login with a valid user")
  public void login() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openLoginPage();
    loginPage.isLoaded();

    loginPage.login("probapet@gmail.com",
        "asddsa");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    loginPage.loginSuccessfully();
  }

  @Test
  @Feature("Login")
  @DisplayName("This shouldn't login with a user")
  @Description("This test is make an unsuccess login with user, and with  Warning: No match for E-Mail Address and/or Password. - message")
  public void loginFailed() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openLoginPage();
    loginPage.isLoaded();

    loginPage.login("probapet@gmail.com",
        "asdds");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    loginPage.loginFailed();
  }
}
