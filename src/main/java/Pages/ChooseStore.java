package Pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.util.Random;
public class ChooseStore {
    private final Page page;
    Locator cookies;
    Locator varuHus;
    Locator vhus;
    Locator valj;
    Locator vhus2 ;
    String store;
    String[] stores = new String[]{"Avesta", "Eskilstuna", "Gävle", "Halmstad"};
    public String valjStore(){
        Random randomStoreOption = new Random();
        int indexOfStore = randomStoreOption.nextInt(stores.length);
        return stores[indexOfStore] ;
    }

    public ChooseStore(Page page) {
        this.page = page;
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
        this.varuHus = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Välj varuhus"));
        this.store= valjStore();
        this.vhus = page
                .getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText(store));
        this.valj = vhus
                .getByRole(AriaRole.BUTTON,
                        new Locator.GetByRoleOptions().setName("VÄLJ"));
        this.vhus2 = page
                .getByRole(AriaRole.BANNER)
                .filter(new Locator.FilterOptions().setHasText(store));
    }

    public void chooseStore(){
        page.navigate("https://www.biltema.se/");
        cookies.click();
        varuHus.click();
        vhus.click();
        valj.click();

    }


    public Locator getCookies() {
        return cookies;
    }

    public void setCookies(Locator cookies) {
        this.cookies = cookies;
    }

    public Locator getVaruHus() {
        return varuHus;
    }

    public void setVaruHus(Locator varuHus) {
        this.varuHus = varuHus;
    }

    public Locator getVhus() {
        return vhus;
    }

    public void setVhus(Locator vhus) {
        this.vhus = vhus;
    }

    public Locator getValj() {
        return valj;
    }

    public void setValj(Locator valj) {
        this.valj = valj;
    }

    public Locator getVhus2() {
        return vhus2;
    }

    public void setVhus2(Locator vhus2) {
        this.vhus2 = vhus2;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String[] getStores() {
        return stores;
    }

    public void setStores(String[] stores) {
        this.stores = stores;
    }
}
