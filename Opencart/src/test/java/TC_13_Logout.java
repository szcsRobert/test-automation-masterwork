import static org.assertj.core.api.Assertions.assertThat;


import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Logout")
public class TC_13_Logout extends BaseTest {

  @Test
  @DisplayName("This should logout the user")
  @Description("Successfully logged out with a previously logged in user")
  public void logout() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    homePage.openLoginPage();
    assertThat(driver.getTitle()).isEqualTo("Account Login");

    loginPage.login("probapet@gmail.com", "asddsa");
    assertThat(driver.getTitle()).isEqualTo("My Account");

    homePage.myAccountLogout();

    makeScreenshot();
    assertThat(driver.getTitle()).isEqualTo("Account Logout");
  }
}
