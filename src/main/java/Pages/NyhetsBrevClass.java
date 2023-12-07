package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import java.util.Random;

public class NyhetsBrevClass {
    private final Page page;
    Locator cookies;
    Locator epost;
    Locator skickaButton;
    Locator spanText;

    String store;
    String[] stores = new String[]{"Avesta", "Eskilstuna", "Gävle", "Halmstad"};

    public String valjStore() {
        Random randomStoreOption = new Random();
        int indexOfStore = randomStoreOption.nextInt(stores.length);
        return stores[indexOfStore];
    }


    public NyhetsBrevClass(Page page) {
        this.page = page;
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Jag accepterar alla cookies"));
        this.epost =page.locator("#footer").getByPlaceholder("Din e-postadress");

        // <input required="" type="email" name="email" autocomple…/> aka getByRole(AriaRole.MAIN).getByPlaceholder("Din e-postadress")
        // <input required="" type="email" name="email" autocomple…/> aka locator("#footer").getByPlaceholder("Din e-postadress")
        this.skickaButton=page.locator("#footer").getByLabel("Anmäl dig till vårt nyhetsbrev");
        this.spanText=page.locator("#footer").getByText
                ("För att kunna slutföra din registrering kommer ett mail" +
                " med en bekräftelselänk skickas till den" +
                " e-postadress som du anger. Klicka på länken i mailet – så är din prenumeration igång. ");



    }


        public void nyhetsBrev() {
            page.navigate("https://www.biltema.se/");
            cookies.click();
            boolean elementFound = false;
            while (!elementFound) {
                try {
                    // Wait for a short period to allow the page to load
                    page.waitForTimeout(1000); // Wait for 1 second (adjust as needed)

                    // Attempt to locate the element

                    if (epost != null) {
                        elementFound = true;
                        // Do something with the element, if needed
                        // ...
                    } else {
                        // If the element is not found, scroll down
                        page.evaluate("window.scrollBy(0, window.innerHeight);");
                    }
                } catch (PlaywrightException e) {
                    // Handle any exceptions that occur during element location
                    e.printStackTrace();
                }
                epost.click();
                epost.fill("halisyilmaz888@gmail.com");
                skickaButton.click();

        }
    }

    public Locator getSpanText() {
        return spanText;
    }

    public void setSpanText(Locator spanText) {
        this.spanText = spanText;
    }
}