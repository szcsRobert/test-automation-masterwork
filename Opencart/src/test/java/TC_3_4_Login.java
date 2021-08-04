import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Opencart WebApplication Interactions")
public class TC_3_4_Login extends BaseTest {

  @Test
  @Feature("Login")
  @Story("Successful Login")
  @DisplayName("Successful user login with previously registered data")
  @Description("This test is make a success login with a valid user")
  public void login() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openLoginPage();
    loginPage.isLoaded();

    loginPage.login("probapet@gmail.com",
        "asddsa");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    myAccountPage.isLoaded();
  }

  @Test
  @Feature("Login")
  @Story("Login failed")
  @DisplayName("Failed user login with invalid password field")
  @Description("This test is make an unsuccess login with user, and with  Warning: No match for E-Mail Address and/or Password. - message")
  public void loginFailed() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    homePage.open();
    homePage.isLoaded();

    myAccountPage.shouldLogout();

    homePage.openLoginPage();
    loginPage.isLoaded();

    loginPage.login("probapet@gmail.com",
        "asdds");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    loginPage.loginFailed();
  }
}
