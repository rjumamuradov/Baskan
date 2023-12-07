package Tests;

import Pages.LoginPage;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends TestBase {
    String eMail = "halisyilmaz888@gmail.com";

    @Test
    void login() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.openLoginPage();
        loginPage.acceptCookies();
        loginPage.login(eMail);
        assertEquals(eMail, loginPage.getEnteredEmail());
    }
}
