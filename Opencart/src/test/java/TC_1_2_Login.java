import Pages.HomePage;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//@Epic("Your Store")
public class TC_1_2_Login extends BaseTest {

  @Test
 // @Feature("Customer Service page")
  @DisplayName("This should sign up a new User on the page")
  public void signUp() {
    HomePage homePage = new HomePage(driver);

    homePage.open();
    homePage.signUp("Trefa",
        "Bela",
        "asdg@gmail",
        "2132131",
        "asddsa");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    homePage.signUpSucessfully();
  }

}
