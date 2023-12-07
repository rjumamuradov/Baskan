package Pages;

import Utilies.ConfigurationReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SearchArtikelPage {
        private final Page page;
        Locator cookies;
        Locator search;
        public SearchArtikelPage(Page page){
           this.page=page;
           this.cookies=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
           this.search=page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Sök"));
        }
        public void searchArtikel(String searchItem){
                page.navigate("https://www.biltema.se/");
                cookies.click();
                search.fill(searchItem);
                search.press("Enter");
        }
    }

