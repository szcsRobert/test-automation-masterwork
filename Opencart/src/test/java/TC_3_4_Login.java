import static org.assertj.core.api.Assertions.assertThat;


import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Login")
public class TC_3_4_Login extends BaseTest {

  @Test
  @Story("Successful Login")
  @DisplayName("Successful user login with previously registered data")
  @Description("This test is make a success login with a valid user")
  public void loginSuccess() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    homePage.openLoginPage();
    assertThat(driver.getTitle()).isEqualTo("Account Login");

    loginPage.login("probapet@gmail.com", "asddsa");

    makeScreenshot();
    assertThat(driver.getTitle()).isEqualTo("My Account");
  }

  @Test
  @Feature("Login")
  @DisplayName("This shouldn't login with a user")
  @Description("This test is make an unsuccess login with user, and with  Warning: " +
      "No match for E-Mail Address and/or Password. - message")
  public void loginFailed() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    homePage.openLoginPage();
    assertThat(driver.getTitle()).isEqualTo("Account Login");

    loginPage.login("probapet@gmail.com", "asdds");

    makeScreenshot();
    assertThat(loginPage.getLoginFailed().isDisplayed()).isTrue();
  }
}
