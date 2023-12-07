package Tests;

import Pages.*;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchArtikelPageTest extends TestBase {
    String searchItems="P-skiva";
    @ Test
    void searchTest() {
        SearchArtikelPage searchArtikel= new SearchArtikelPage(page);
        searchArtikel.searchArtikel(searchItems);
        assertThat(page).hasURL(Pattern.compile(".*/?query="+ searchItems));
    }
}
