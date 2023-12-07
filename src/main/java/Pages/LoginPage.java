package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
    private final Page page;
    Locator mittBiltema;
    Locator loggaIn;
    Locator googleLink;
    Locator epost;
    Locator nextButton;
    //Locator nextButton2;
   // Locator passwordTextBox;
   // Locator showPassWordCheckBox;
    String enteredEmail;
    Locator acceptCookiesButton;

    //Locator inloggningenMisslyckades;
    String elementText ;

    // AssertJ assertThat() metoduyla element metnini doğrulayın


    public LoginPage(Page page) {
        this.page = page;
        this.mittBiltema = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logga in på Mitt Biltema"));
        this.loggaIn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logga in").setExact(true));
        this.googleLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("GOOGLE"));
        this.epost=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-post eller telefonnummer"));
        this.acceptCookiesButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
        this.enteredEmail=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-post eller telefonnummer")).inputValue();

    }

    public void openLoginPage() {
        String loginUrl = "https://www.biltema.se/";
        page.navigate(loginUrl);
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public void login(String eMail) {
        mittBiltema.click();
        loggaIn.click();
        googleLink.click();
        epost.fill(eMail);
    }

    public String getEnteredEmail() {
        return enteredEmail;
    }

    public void setEnteredEmail(String enteredEmail) {
        this.enteredEmail = enteredEmail;
    }
}
