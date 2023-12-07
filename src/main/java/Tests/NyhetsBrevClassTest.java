package Tests;

import Pages.NyhetsBrevClass;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NyhetsBrevClassTest extends TestBase {
     @Test
    void nyhetsBrev(){
        NyhetsBrevClass nyhetsBrev= new NyhetsBrevClass(page);
        nyhetsBrev.nyhetsBrev();
        assertThat(nyhetsBrev.getSpanText()).isVisible();
     }
}
