package Tests;

import Pages.ChooseStore;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ChooseStoreTest extends TestBase {

    @Test
    void  storeTest() {
        ChooseStore store = new ChooseStore(page);
        store.chooseStore();
        assertThat(store.getVhus2()).isVisible();
    }
}
