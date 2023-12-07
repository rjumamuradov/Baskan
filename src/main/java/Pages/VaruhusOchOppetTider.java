package Pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import java.util.Random;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VaruhusOchOppetTider {
    private final Page page;
    Locator cookies;
    Locator varuhusOchOppetTider;
    Locator headerAndTime;
    String store;
    String[] stores = new String[]{"Avesta", "Eskilstuna", "Gävle", "Halmstad"};
    public String valjStore() {
        Random randomStoreOption = new Random();
        int indexOfStore = randomStoreOption.nextInt(stores.length);
        return stores[indexOfStore];
    }
    public VaruhusOchOppetTider(Page page) {
        this.page = page;
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
        this.varuhusOchOppetTider = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().
                setName("Varuhus och öppettider"));
        this.headerAndTime=page.locator("//a[text()=\"Avesta\"]/following-sibling::span");
        this.store = valjStore();
    }

    void waitUntilElement() {
        }

    public Locator getHeaderAndTime() {
        return headerAndTime;
    }

    public void varuhusAndOppetTider() {
            page.navigate("https://www.biltema.se/");
            cookies.click();
            varuhusOchOppetTider.click();
            System.out.println(headerAndTime.allInnerTexts());
        }

    }
