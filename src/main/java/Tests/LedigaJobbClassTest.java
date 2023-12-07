package Tests;

import Pages.ChooseStore;
import Pages.LedigaJobbClass;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LedigaJobbClassTest extends TestBase {

    @Test
    void  ledigJobbTest() {
        LedigaJobbClass jobb = new LedigaJobbClass(page);
        jobb.ledigaJobb();
        assertThat(page).hasURL("https://www.biltema.se/om-biltema/jobba-pa-biltema/lediga-tjanster/");

    }
}
