package Pages;

import Utilies.ConfigurationReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class FindArtikelToYourBil {
        private final Page page;
        Locator cookies;
        Locator bilAndMcLocator;
        Locator registeringsNummer;
        Locator fordonsBatterier;
        Locator laggTill;
        Locator kundVagn;
        Locator artikelIKundvagn;
        Locator gåTillKassan;
        String store;
        Locator varuHus;
        Locator vhus;
        Locator valj;
        public FindArtikelToYourBil(Page page){
           this.page=page;
           this.cookies=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
           this.bilAndMcLocator=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bil - MC"));
           this.registeringsNummer=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ABC 123"));
           this.fordonsBatterier=page.locator("#react__navigation-tree").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Fordonsbatterier"));
           this.laggTill=page.getByLabel("Lägg till", new Page.GetByLabelOptions().setExact(true));
           this.kundVagn=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kundvagn"));
           this.artikelIKundvagn=page.getByTitle("Startbatteri SMF, 12 V, 50 Ah");
           this.gåTillKassan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gå till kassan"));
           this.varuHus = page.locator(".sidemenu__storeselector").first();
           this.store="Malmö";
           this.vhus = page
                    .getByRole(AriaRole.LISTITEM)
                    .filter(new Locator.FilterOptions().setHasText(store));
            this.valj = vhus
                    .getByRole(AriaRole.BUTTON,
                            new Locator.GetByRoleOptions().setName("VÄLJ"));
        }
        public void enterYourBilRegisteringsNummer(){
                page.navigate("https://www.biltema.se/");
                cookies.click();
                bilAndMcLocator.click();
                registeringsNummer.fill(ConfigurationReader.getProperty("registeringsNummer"));
                registeringsNummer.press("Enter");
                fordonsBatterier.click();
                laggTill.click();
                kundVagn.click();
                varuHus.click();
                vhus.click();
                valj.click();
                gåTillKassan.click();
        }

    public Locator getArtikelIKundvagn() {
        return artikelIKundvagn;
    }
}

