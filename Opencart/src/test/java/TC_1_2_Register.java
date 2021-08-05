import static org.assertj.core.api.Assertions.assertThat;


import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Registration")
public class TC_1_2_Register extends BaseTest {

  @Test
  @Story("Successful Registration")
  @DisplayName("Successful user account registration with valid data")
  @Description("This test is make a success register with valid values, " +
      "and with Your Account Has Been Created! - message")
  public void signUp() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

    homePage.openRegisterPage();

    makeScreenshot();
    registerPage.signUp("Trefa",
        "Bela",
        "2132131",
        "asddsa",
        "asddsa");

    makeScreenshot();
    assertThat(registerPage.getSignUpSuccessMessage().getText())
        .contains("Your Account Has Been Created!");
  }

  @Test
  @Story("Failed Registration")
  @DisplayName("Failed to register user account with corrupted confirmation password")
  @Description("This test is make an unsuccess register, with Password confirmation " +
      "does not match password! - message")
  public void signUpFailed() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

    homePage.openRegisterPage();

    makeScreenshot();
    registerPage.signUp("Trefa",
        "Bela",
        "2132131",
        "asddsa",
        "asdds");

    makeScreenshot();
    assertThat(registerPage.getSignUpFailedMessage().getText())
        .isEqualTo("Password confirmation does not match password!");
  }
}
