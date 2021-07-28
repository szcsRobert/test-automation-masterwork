import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store")
public class TC_1_2_Register extends BaseTest {

  @Test
  @Feature("Register")
  @DisplayName("This should sign up a new User on the page")
  @Description("This test is make a success register with valid values, and with Your Account Has Been Created! - message")
  public void signUp() {
    HomePage homePage = new HomePage(driver);

    homePage.open();

    homePage.signUp("Trefa",
        "Bela",
        "asdg2@gmail.com",
        "2132131",
        "asddsa");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    homePage.signUpSucessfully();
  }


  @Test
  @Feature("Register")
  @DisplayName("This shouldn't sign up a new User on the page")
  @Description("This test is make an unsuccess register, with Warning: E-Mail Address is already registered! - message")
  public void signUpFailed() {
    HomePage homePage = new HomePage(driver);

    homePage.open();

    homePage.signUp("Trefa",
        "Bela",
        "asdg1@gmail.com",
        "2132131",
        "asddsa");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    homePage.signUpFailed();
  }

}
