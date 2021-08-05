import static org.assertj.core.api.Assertions.assertThat;


import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Registration")
public class TC_5_Privacy_Policy extends BaseTest {

  @Test
  @Story("Successful Registration")
  @DisplayName("Successful user account registration with use privacy statement")
  @Description("This test is make a success register with valid values, and with open the privacy policy")
  public void signUpWithPpCheck() {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

    homePage.openRegisterPage();

    registerPage.signUpWithPpCheck("Trefa",
        "Bela",
        "2132131",
        "asddsa",
        "asddsa");

    assertThat(registerPage.getSignUpSuccessMessage().getText())
        .contains("Your Account Has Been Created!");
  }
}
