package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LedigaJobbClass {
    private final Page page;
    Locator cookies;
    Locator jobbLink;
    Locator ledigaTjanster;
    Locator sokfalt;
    Locator region;
    Locator stockholm;

    public LedigaJobbClass(Page page) {
        this.page = page;
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
        this.jobbLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Jobb").setExact(true));
        this.ledigaTjanster = page.locator("[id*=react] [href*=lediga][class]");
        //this.sokfalt = page.locator("[id*=job_search] [name=search_text]");
        this.region = page.locator("[id*=search] [id*=search_region]");

    }

    public void ledigaJobb() {
        page.navigate("https://www.biltema.se/");
        cookies.click();
        jobbLink.click();
        ledigaTjanster.click();
    }
}



