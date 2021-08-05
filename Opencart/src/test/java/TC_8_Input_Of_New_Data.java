import static org.assertj.core.api.Assertions.assertThat;


import Pages.ContactUsPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@Epic("Opencart WebApplication Interactions")
@Feature("Input new data")
public class TC_8_Input_Of_New_Data extends BaseTest {

  @Test
  @DisplayName("Contact with support")
  @Description("This test is sending a complaint to the support")
  public void sendNewsToTheSupport() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    ContactUsPage contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);

    homePage.getContactUsPage().click();
    assertThat(driver.getTitle()).isEqualTo("Contact Us");

    contactUsPage.contact("Peter Proba",
        "probapet@gmail.com",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi" +
            " ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit" +
            " in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
            "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    makeScreenshot();
    assertThat(driver.getCurrentUrl()).isEqualTo(
        "http://test-automation-shop2.greenfox.academy/index.php?route=information/contact/success");
  }
}
