package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddToCart {
    private final Page page;
    Locator cookies;
    Locator search;
    Locator searchedItem;
    Locator varukorg;
    Locator PskivaIkorgen;
    //assertThat(PskivaIkorgen).isVisible();
    Locator valjVaruHus;
    Locator vhus1 ;
    Locator vhus2;
    Locator itemInCart;
    Locator gåTillKassan;

    //assertThat(page).hasURL("https://checkout.biltema.se/");

    public AddToCart(Page page) {
        this.page=page;
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
        this.search = page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Sök"));
        this.searchedItem = page.	locator("li").filter(new Locator.FilterOptions().setHasText("P-skiva37-461Bilinteriör/Parkeringstillbehör3490Lägg till")).getByLabel("Lägg till",
                new Locator.GetByLabelOptions().setExact(true));
        this.varukorg = page.getByText("Kundvagn");
        this.PskivaIkorgen = page.locator("#productslist").getByText("P-skiva");
        this.valjVaruHus = page.getByLabel("Välj varuhus");
        this.vhus1 = page
                .getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("Eskilstuna"));
        this.vhus2=vhus1.getByRole(AriaRole.BUTTON,
                new Locator.GetByRoleOptions().setName("VÄLJ"));
        this.itemInCart=page.getByTitle("P-skiva");
        this.gåTillKassan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gå till kassan"));
    }
    public void addToCart(){
        page.navigate("https://www.biltema.se/");
        cookies.click();
        search.fill("P-Skiva");
        search.press("Enter");
        searchedItem.click();
        varukorg.click();
        valjVaruHus.click();
        vhus2.click();
        gåTillKassan.click();
    }

    public Locator getItemInCart() {
        return itemInCart;
    }
}

