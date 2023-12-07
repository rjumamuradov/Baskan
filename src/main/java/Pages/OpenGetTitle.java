package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class OpenGetTitle {
    private final Page page;
    Locator cookies;
    String title;
   public OpenGetTitle(Page page) {
        this.page =page;
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Jag accepterar alla cookies"));
        this.title="Biltema – Varför betala mer? - Biltema.se";
    }

    public void openAndGetTitle(){
        page.navigate("https://www.biltema.se/");
        cookies.click();
        page.title();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
