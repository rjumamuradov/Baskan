package Tests;

import Pages.FindArtikelToYourBil;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FindArtikelToYourBilTest extends TestBase {

    @Test
    void fyllaRegisteringsNummer(){
        FindArtikelToYourBil geRegisteringsNummer= new FindArtikelToYourBil(page);
        geRegisteringsNummer.enterYourBilRegisteringsNummer();
        assertThat(geRegisteringsNummer.getArtikelIKundvagn()).hasText("Startbatteri SMF, 12 V, 50 Ah");
        assertThat(page).hasURL("https://checkout.biltema.se/");
    }
}
