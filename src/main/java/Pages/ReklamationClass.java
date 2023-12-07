package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.Random;

public class ReklamationClass {
    private final Page page;
    Locator cookies;
    Locator kundService;
    Locator returerOchreklamationer;
    Locator arnLocator;

    String store;
    String[] stores = new String[]{"Avesta", "Eskilstuna", "Gävle", "Halmstad"};

    public String valjStore() {
        Random randomStoreOption = new Random();
        int indexOfStore = randomStoreOption.nextInt(stores.length);
        return stores[indexOfStore];
    }


    public ReklamationClass(Page page) {
        this.page = page;
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
        this.kundService= page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kundservice")).first();
        this.arnLocator=page.getByText("www.arn.se");
        this.returerOchreklamationer=page.getByText("Returer och reklamationer");
    }

        public void reklamation() {
            page.navigate("https://www.biltema.se/");
            cookies.click();
            kundService.click();
            returerOchreklamationer.click();
            arnLocator.click();
        }
    }