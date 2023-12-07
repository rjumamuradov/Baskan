package Tests;

import Pages.ChangeLanguage;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ChangeLanguageTest extends TestBase {

    @Test
    void changeWebsiteLanguageTest(){
        ChangeLanguage changeLanguage=new ChangeLanguage(page);
        changeLanguage.changeWebsiteLanguage();
        assertThat(changeLanguage.getSelectedLanguage()).isVisible();
    }
}
