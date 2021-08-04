import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Opencart WebApplication Interactions")
public class TC_1_2_Register extends BaseTest {

  @Test
  @Feature("Registration")
  @Story("Successful Registration")
  @DisplayName("Successful user account registration with valid data")
  @Description("This test is make a success register with valid values, and with Your Account Has Been Created! - message")
  public void signUp() {
    HomePage homePage = new HomePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);

    homePage.open();
    homePage.isLoaded();

    homePage.openRegisterPage();
    registerPage.isLoaded();

    registerPage.signUp("Trefa",
        "Bela",
        "2132131",
        "asddsa",
        "asddsa");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    registerPage.signUpSuccessfully();
  }

  @Test
  @Feature("Registration")
  @Story("Failed Registration")
  @DisplayName("Failed to register user account with corrupted confirmation password")
  @Description("This test is make an unsuccess register, with Warning: E-Mail Address is already registered! - message")
  public void signUpFailed() {
    HomePage homePage = new HomePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);

    homePage.open();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    homePage.isLoaded();
    homePage.openRegisterPage();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    registerPage.isLoaded();

    registerPage.signUp("Trefa",
        "Bela",
        "2132131",
        "asddsa",
        "asdds");

    registerPage.signUpFailed();
  }
}
