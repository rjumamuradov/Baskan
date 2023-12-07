package Tests;

import Pages.ReklamationClass;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ReklamationClassTest extends TestBase {
     @Test
    void reklamation(){
        ReklamationClass kontakKundS= new ReklamationClass(page);
        kontakKundS.reklamation();
        assertThat(page).hasURL("https://www.arn.se/");
     }
}
